package config;

/**
 * Created by Vigo on 16/3/31.
 */
public class Configuration {

    /** 设置ticketKey存放位置 */
    public static final String cookieName ="SSO_ID";

    /** 设置ticket有效时间(天数) */
    public static final int ticketTimeout = 1;

    /** 设置ticket有效时间(天数) */
    public static final String SSOLoginPage = "http://127.0.0.1:8080/SSOAuth/login.jsp";
}
