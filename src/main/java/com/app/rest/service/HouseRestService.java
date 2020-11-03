package com.app.rest.service;

import com.app.entities.House;
import com.app.repositories.HouseRepository;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("house")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HouseRestService {
    @Inject
    HouseRepository houseRepository;

    @Path("create") // POST api/v1/house/create
    @POST
    public Response createHouse(House house) {
        return Response.ok(houseRepository.createHouse(house)).build();
    }

    @Path("update") // PUT api/v1/house/update
    @PUT
    public Response updateHouse(House house) {
        return Response.ok(houseRepository.updateHouse(house)).build();
    }

    @Path("delete") // DELETE api/v1/house/delete
    @DELETE
    public Response deleteHouse(House house) {
        return Response.ok(houseRepository.deleteHouse(house)).build();
    }

    @Path("{id}") // GET api/v1/house/{id}
    @GET
    public House getHouse(@PathParam("id") int id) {
        return houseRepository.findHouseById(id);
    }

    @Path("list") // GET api/v1/house/list
    @GET
    public List<House> getHouses() {
        return houseRepository.getAllHouses();
    }
}
