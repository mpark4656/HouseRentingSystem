package com.app.filters;

import com.app.entities.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="AppFilter", urlPatterns={"/*"})
public class AppFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String loginURL = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().endsWith("login.jsp");
        boolean isLoginURL = httpRequest.getRequestURI().equals(loginURL);

        String contextPath = httpRequest.getContextPath();

        // Excluded directories from this filter
        if(httpRequest.getRequestURI().startsWith(contextPath + "/css") ||
                httpRequest.getRequestURI().startsWith(contextPath + "/js") ||
                httpRequest.getRequestURI().startsWith(contextPath + "/img") ||
                httpRequest.getRequestURI().startsWith(contextPath + "/api/")
        ) {
            filterChain.doFilter(request, response);
            return;
        }

        // Session is not live and the request isn't for login, then redirect to login page
        if(session == null && !isLoginRequest && !isLoginURL) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        // Session is live and request isn't for login
        if(session != null && !isLoginRequest && !isLoginURL) {
            User user = (User)session.getAttribute("user");
            if(user == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                return;
            }
        }

        // Session is live and request is for login
        if(session != null && (isLoginRequest || isLoginURL)) {
            User user = (User)session.getAttribute("user");
            if(user != null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
