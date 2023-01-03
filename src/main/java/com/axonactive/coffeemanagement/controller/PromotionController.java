package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.controller.request.PromotionRequest;
import com.axonactive.coffeemanagement.service.PromotionService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Stateless
@Path(value = PromotionController.PATH)
public class PromotionController {
    public static final String PATH = "/promotions";

    @Inject
    private PromotionService promotionService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(promotionService.findAll()).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(promotionService.findById(id)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/expired")
    public Response getByNotExpired() {
        return Response.ok().entity(promotionService.findByNotExpired()).status(Response.Status.FOUND).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(@Valid PromotionRequest promotionRequest) {
        return Response.ok().entity(promotionService.create(promotionRequest)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(@Valid PromotionRequest promotionRequest, @PathParam("id") Long id) {
        return Response.ok().entity(promotionService.update(promotionRequest, id)).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        promotionService.delete(id);
        return Response.ok().status(Response.Status.OK).build();
    }
}
