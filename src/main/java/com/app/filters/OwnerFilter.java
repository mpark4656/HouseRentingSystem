package com.app.filters;

import com.app.entities.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="OwnerFilter", urlPatterns={"/owner/*"})
public class OwnerFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {}

    @Override
    public void destroy() {}

    @Override
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
                if(!user.isAdministrator() && !user.isOwner()) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/home");
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
