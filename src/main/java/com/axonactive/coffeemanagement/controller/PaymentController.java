package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.service.PaymentService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = PaymentController.PATH)
public class PaymentController {
    public static final String PATH = "/payments";

    @Inject
    private PaymentService paymentService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(paymentService.findAll()).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(paymentService.findById(id)).status(Response.Status.FOUND).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(@Valid PaymentRequest paymentRequest) {
        return Response.ok().entity(paymentService.create(paymentRequest)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(@Valid PaymentRequest paymentRequest, @PathParam("id") Long id) {
        return Response.ok().entity(paymentService.update(paymentRequest, id)).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        paymentService.delete(id);
        return Response.ok().status(Response.Status.OK).build();
    }
}
