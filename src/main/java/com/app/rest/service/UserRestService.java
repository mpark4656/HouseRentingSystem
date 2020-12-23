package com.app.rest.service;

import com.app.entities.User;
import com.app.repositories.UserRepository;
import com.app.security.UserAuthentication;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("user")
public class UserRestService extends RestService<User> {
    @Inject
    UserRepository userRepository;

    @Path("find-username/{username}")
    @GET
    public Response get(@PathParam("username") String username) {
        return Response.ok(userRepository.findByUsername(username)).build();
    }

    @Path("username-exists/{username}")
    @GET
    public Response usernameExists(@PathParam("username") String username) {
        return Response.ok(userRepository.usernameExists(username)).build();
    }

    @Path("email-exists/{email}")
    @GET
    public Response emailExists(@PathParam("email") String email) {
        return Response.ok(userRepository.emailExists(email)).build();
    }

    @Path("delete-by-username")
    @DELETE
    public Response deleteByUsername(@QueryParam("username") String username) {
        if(username.equals(UserAuthentication.ROOT_USERNAME)) {
            return Response.status(403, "The default root account can not be deleted").build();
        }

        User user = userRepository.deleteByUsername(username);
        if(user == null) {
            return Response.status(404, "Unable to find this user").build();
        } else {
            return Response.ok(user).build();
        }
    }

    @Path("update-user")
    @PUT
    public Response updateUser(@Valid User user) {
        // Don't trust the user ID coming from the client
        // Use the username to pull the correct id.
        // If username isn't found, reject the request call
        if(user.getUsername().equals(UserAuthentication.ROOT_USERNAME)) {
            return Response.status(403, "The default root account can not be changed").build();
        }

        User currentUser = userRepository.findByUsername(user.getUsername());

        if(currentUser == null) {
            return Response.status(404, "Unable to find this user").build();
        }

        currentUser.setFirstName(user.getFirstName().toUpperCase());
        currentUser.setLastName(user.getLastName().toUpperCase());
        currentUser.setEmailAddress(user.getEmailAddress().toUpperCase());
        currentUser.setRoles(user.getRoles());
        userRepository.update(currentUser);

        return Response.ok(currentUser).build();
    }
}
