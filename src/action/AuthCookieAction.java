package action;

import com.alibaba.fastjson.JSONObject;
import po.Ticket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 验证Cookie是否有效
 * Created by Vigo on 16/3/30.
 */
public class AuthCookieAction{

    /** 单点登录标记 */
    private Map<String, Ticket> tickets;

    public AuthCookieAction(Map<String, Ticket> tickets) {
        this.tickets = tickets;
    }

    public void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /** 获取ticket */
        String ticketKey = request.getParameter("cookieValue");

        JSONObject resultJSON = new JSONObject();
            /** 认证ticket是否有效*/
            if (tickets.containsKey(ticketKey)){
                /** 验证Ticket是否过期*/
                if (isTicketInvalid(ticketKey)){
                    /** 过期移除ticket */
                    tickets.remove(ticketKey);
                    resultJSON.put("error", true);
                    resultJSON.put("errorInfo", "Ticket is not invalid!");
                }else {
                    resultJSON.put("error", false);
                    resultJSON.put("email", tickets.get(ticketKey).getUser().getEmail());
                    resultJSON.put("userId", tickets.get(ticketKey).getUser().getUser_id());
                }

            } else {
                resultJSON.put("error", true);
                resultJSON.put("errorInfo", "Ticket is not found!");
            }
        /** 输出返回*/
        PrintWriter out = response.getWriter();
        out.print(resultJSON.toJSONString());
        }


    private boolean isTicketInvalid(String ticketKey){
        Ticket ticket = tickets.get(ticketKey);
        return ticket.isInvalid();
    }
}
