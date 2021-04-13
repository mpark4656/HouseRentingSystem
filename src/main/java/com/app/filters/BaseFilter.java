package com.app.filters;

import com.app.entities.User;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

abstract class BaseFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        if(session == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        } else {
            User user = (User) session.getAttribute("user");
            if(user == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                return;
            } else {
                if(!isProperUserRole(user)) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    abstract boolean isProperUserRole(User user);
}
