package com.app.rest.service;

import com.app.entities.User;
import com.app.repositories.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("user")
public class UserRestService extends RestService<User> {
    @Inject
    UserRepository userRepository;

    @Path("find-username/{username}")
    public Response get(@PathParam("username") String username) {
        return Response.ok(userRepository.findByUsername(username)).build();
    }

    @Path("exists/{username}")
    public Response exists(@PathParam("username") String username) {
        return Response.ok(userRepository.usernameExists(username)).build();
    }
}
