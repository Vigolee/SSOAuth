package util;


import exception.CookieNotFoundException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

	public void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {

			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					System.out.println("SSOAuth: set cookie maxage = 0: "
							+ cookie.getName()+" - "+cookie.getValue());
					Cookie deleteCookie = new Cookie(cookie.getName(), "hello world");
					deleteCookie.setPath(cookie.getPath());
					deleteCookie.setMaxAge(0);
					response.addCookie(deleteCookie);
				}
			}
		}
	}

	public Cookie generateCookie(String cookieName, String value, int expiry, String path) {
		Cookie cookie = new Cookie(cookieName, value);
		cookie.setMaxAge(expiry);
		cookie.setPath(path);
		return cookie;
	}
	
	/**
	 * 获取cookie
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 * @throws CookieNotFoundException
	 */
	public Cookie getCookie(HttpServletRequest request,String cookieName) throws CookieNotFoundException {
		Cookie targetCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					targetCookie = cookie;
					break;
				}
			}
		}
		if (targetCookie != null) {
			return targetCookie;
		} else {
			throw new CookieNotFoundException();
		}
	}
	
}
