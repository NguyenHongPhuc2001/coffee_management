package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.service.FoodService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = FoodController.PATH)
public class FoodController {
    public static final String PATH="/foods";

    @Inject
    private FoodService foodService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll(){
        return Response.ok().entity(foodService.findAll()).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id")Long id){
        return Response.ok().entity(foodService.findById(id)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/current_price")
    public Response getByCurrentPriceBetween(@QueryParam("startPrice") Double startPrice, @QueryParam("endPrice") Double endPrice){
        return Response.ok().entity(foodService.findByCurrentPriceBetween(startPrice,endPrice)).status(Response.Status.FOUND).build();
    }




}
