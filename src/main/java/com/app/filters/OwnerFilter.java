package com.app.filters;

import com.app.entities.User;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="OwnerFilter", urlPatterns={"/owner/*"})
public class OwnerFilter extends BaseFilter {
    @Override
    boolean isProperUserRole(User user) {
        return user.isOwner();
    }
}
