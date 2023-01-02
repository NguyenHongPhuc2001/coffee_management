package com.axonactive.coffeemanagement.controller;


import com.axonactive.coffeemanagement.controller.request.DrinkRequest;
import com.axonactive.coffeemanagement.service.DrinkService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = DrinkController.PATH)
public class DrinkController {

    public static final String PATH = "/drinks";

    @Inject
    private DrinkService drinkService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(drinkService.findAll()).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(drinkService.findById(id)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/current_price")
    public Response getByCurrentPriceBetween(@QueryParam("startPrice") Double startPrice, @QueryParam("endPrice") Double endPrice) {
        return Response.ok().entity(drinkService.findByCurrentPriceBetween(startPrice, endPrice)).status(Response.Status.FOUND).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(DrinkRequest drinkRequest) {
        return Response.ok().entity(drinkService.create(drinkRequest)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(DrinkRequest drinkRequest, @PathParam("id") Long id) {
        return Response.ok().entity(drinkService.update(drinkRequest, id)).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        drinkService.delete(id);
        return Response.ok().status(Response.Status.OK).build();
    }

}
