package com.app.filters;

import com.app.entities.User;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="CustomerFilter", urlPatterns={"/customer/*"})
public class CustomerFilter extends BaseFilter {
    @Override
    boolean isProperUserRole(User user) {
        return user.isCustomer();
    }
}
