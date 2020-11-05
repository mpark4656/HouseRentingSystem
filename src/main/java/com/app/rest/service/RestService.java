package com.app.rest.service;

import com.app.repositories.Repository;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class RestService<T> {
    @Inject
    protected Repository<T> repository;

    @POST
    @Path("create") // POST api/v1/T/create
    public Response create(T t) {
        return Response.ok(repository.create(t)).build();
    }

    @Path("update") // PUT api/v1/T/update
    @PUT
    public Response update(T t) {
        return Response.ok(repository.update(t)).build();
    }

    @Path("delete") // DELETE api/v1/T/delete
    @DELETE
    public Response delete(T t) {
        return Response.ok(repository.delete(t)).build();
    }

    @Path("delete/{id}") // DELETE api/v1/T/delete/{id}
    @DELETE
    public Response deleteById(@PathParam("id") int id) {
        return Response.ok(repository.deleteById(id)).build();
    }

    @Path("get/{id}") // GET api/v1/T/get/{id}
    @GET
    public Response get(@PathParam("id") int id) {
        return Response.ok(repository.find(id)).build();
    }

    @Path("list") // GET api/v1/T/list
    @GET
    public Response list() {
        return Response.ok(repository.list()).build();
    }
}
