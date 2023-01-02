package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.service.DrinkService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = DrinkAndCategoryController.PATH)
public class DrinkAndCategoryController {
    public static final String PATH = "/{categoryId}/drinks";

    @Inject
    private DrinkService drinkService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/current_price")
    public Response getByCurrentPriceBetweenAndCategory(@QueryParam("startPrice") Double startPrice, @QueryParam("endPrice") Double endPrice, @PathParam("categoryId") Long categoryId) {
        return Response.ok().entity(drinkService.findByCurrentPriceBetweenAndCategory(startPrice, endPrice, categoryId)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getByCategory(@PathParam("categoryId") Long categoryId) {
        return Response.ok().entity(drinkService.findByCategoryId(categoryId)).status(Response.Status.FOUND).build();
    }
}
