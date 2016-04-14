package sso;

import action.AuthCookieAction;
import action.LoginAction;
import action.ResetCookieAction;
import po.Ticket;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Created by Vigo on 16/3/30.
 */
public class SSOAuth extends HttpServlet {

    /** 单点登录标记 */
    private Map<String, Ticket> tickets;

    public void init(ServletConfig config) throws ServletException {
        tickets = new ConcurrentHashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestAction = request.getParameter("action");

        if (requestAction.equals("login")){

            LoginAction action = new LoginAction(tickets);
            action.doAction(request, response);

        } else if (requestAction.equals("authCookie")){

            AuthCookieAction action = new AuthCookieAction(tickets);
            action.doAction(request, response);

        } else if (requestAction.equals("resetCookie")){

            ResetCookieAction action = new ResetCookieAction(tickets);
            action.doAction(request, response);
        }
    }
}
