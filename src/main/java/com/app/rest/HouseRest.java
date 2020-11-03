package com.app.rest;

import com.app.entity.House;
import com.app.service.HouseService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("house")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HouseRest {
    @Inject
    HouseService houseService;

    @Path("create") // api/v1/house/create
    @POST
    public Response createHouse(House house) {
        return Response.ok(houseService.createHouse(house)).build();
    }

    @Path("update") // api/v1/house/update
    @POST
    public Response updateHouse(House house) {
        return Response.ok(houseService.updateHouse(house)).build();
    }

    @Path("{id}") // api/v1/house/{id}
    @GET
    public House getHouse(@PathParam("id") int id) {
        return houseService.findHouseById(id);
    }

    @Path("list") // api/v1/house/list
    @GET
    public List<House> getHouses() {
        return houseService.getAllHouses();
    }
}
