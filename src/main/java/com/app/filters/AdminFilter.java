package com.app.filters;

import com.app.entities.User;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="AdminFilter", urlPatterns={"/admin/*"})
public class AdminFilter extends BaseFilter {
    @Override
    boolean isProperUserRole(User user) {
        return user.isAdministrator();
    }
}
