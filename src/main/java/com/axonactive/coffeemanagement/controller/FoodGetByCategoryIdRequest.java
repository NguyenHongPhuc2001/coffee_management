package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.service.FoodService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = FoodGetByCategoryIdRequest.PATH)
public class FoodGetByCategoryIdRequest {
    public static final String PATH="/{categoryId}/foods";

    @Inject
    private FoodService foodService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getByCategoryId(@PathParam("categoryId") Long categoryId){
        return Response.ok().entity(foodService.findByCategoryId(categoryId)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/current_price")
    public Response getByCurrentPriceBetween(@QueryParam("startPrice") Double startPrice, @QueryParam("endPrice") Double endPrice, @PathParam("categoryId") Long categoryId){
        return Response.ok().entity(foodService.findByCurrentPriceBetweenAndCategory(startPrice,endPrice,categoryId)).status(Response.Status.FOUND).build();
    }
}
