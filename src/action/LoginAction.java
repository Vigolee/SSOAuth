package action;

import com.alibaba.fastjson.JSONObject;
import config.Configuration;
import dao.UserDao;
import po.Ticket;
import po.User;
import util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 登陆处理类
 * Created by Vigo on 16/3/30.
 */
public class LoginAction{

    /** 单点登录标记 */
    private Map<String, Ticket> tickets;

    public LoginAction(Map<String, Ticket> tickets) {
        this.tickets = tickets;
    }

    public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        /** 获取用户信息 */
        UserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);

        if (checkUserInfo(user, password)){

            /** 生成唯一标识符 */
            String ticketKey = UUID.randomUUID().toString().replace("-", "");
            System.out.println("SSO_ID: " + ticketKey);
            /** 创建ticket */
            Ticket ticket = new Ticket(new Date(), Configuration.ticketTimeout, user);
            /** 登陆信息存入hash */
            tickets.put(ticketKey, ticket);
            /** 默认Cookie一天有效 */
            int expiry = 24 * 3600;
            String gotoURL = request.getParameter("gotoURL");
            String setCookieURL = request.getParameter("setCookieURL");
            if (setCookieURL != null){
                response.sendRedirect(setCookieURL + "?ticketKey="
                        + ticketKey + "&expiry=" + expiry
                        + "&gotoURL=" + gotoURL);
            }

        }else {
            JSONObject result = new JSONObject();
            result.put("state", 1);
            result.put("errMsg", "email or password is wrong!");
            result.put("protocol_id", "A-7-2-1-response");
            response.getWriter().write(result.toJSONString());

            System.out.println("error : email: "+email+" - "+"password: "+password);
        }

    }

    /**
     * 检查用户名和密码是否正确
     * @param user
     * @param password
     * @return
     */
    private boolean checkUserInfo(User user, String password){
        boolean flag = true;//认证成功
        if (user == null || !user.getPassword().equals(password)){
            flag = false;
        }
        return flag;
    }


}
