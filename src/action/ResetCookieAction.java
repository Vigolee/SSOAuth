package action;

import config.Configuration;
import po.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 系统间跳转，重新设置Cookie
 * Created by Vigo on 16/3/30.
 */
public class ResetCookieAction{

    /** 单点登录标记 */
    private Map<String, Ticket> tickets;

    public ResetCookieAction(Map<String, Ticket> tickets) {
        this.tickets = tickets;
    }

    public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ticketKey = request.getParameter("cookieValue");
        String setCookieURL = request.getParameter("setCookieURL");
        String gotoURL = request.getParameter("gotoURL");

            /** 认证ticket是否有效*/
            if (tickets.containsKey(ticketKey)){
                /** 验证Ticket是否过期*/
                if (isTicketInvalid(ticketKey)){
                    /**
                     * Ticket过期，删除Ticket，重定向到登陆页面
                     */
                    tickets.remove(ticketKey);
                    response.sendRedirect(Configuration.SSOLoginPage + "?setCookieURL=" + setCookieURL+ "/setCookie&gotoURL=" + gotoURL);
                    System.out.println("Ticket过期，重定向到登陆页面");
                }else {
                    /** 重新生成Cookie到指定域名下 */
                    /** 默认Cookie一天有效 */
                    int expiry = 24 * 3600;
                    if (setCookieURL != null){
                        System.out.println("重定向：" + setCookieURL + "?ticketKey="
                                + ticketKey + "&expiry=" + expiry
                                + "&gotoURL=" + gotoURL);
                        response.sendRedirect(setCookieURL + "?ticketKey="
                                + ticketKey + "&expiry=" + expiry
                                + "&gotoURL=" + gotoURL);
                    }
                }

            } else {
                /**
                 * 重定向到登陆页面
                 */
                response.sendRedirect(Configuration.SSOLoginPage + "?setCookieURL=" + setCookieURL+ "/setCookie&gotoURL=" + gotoURL);
                System.out.println("Ticket过期，重定向到登陆页面");
                System.out.println("重定向到登陆页面");
            }

    }

    private boolean isTicketInvalid(String ticketKey){
        Ticket ticket = tickets.get(ticketKey);
        return ticket.isInvalid();
    }
}
