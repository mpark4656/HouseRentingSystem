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

        if(httpRequest.getRequestURI().endsWith(".css") ||
                httpRequest.getRequestURI().endsWith(".js") ||
                httpRequest.getRequestURI().endsWith(".png")
        ) {
            filterChain.doFilter(request, response);
            return;
        }

        if(session == null && !isLoginRequest && !isLoginURL) {
            httpResponse.sendRedirect("login");
            return;
        }

        if(session != null && !isLoginRequest && !isLoginURL) {
            User user = (User)session.getAttribute("user");
            if(user == null) {
                httpResponse.sendRedirect("login");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
