package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.controller.request.BillDetailRequest;
import com.axonactive.coffeemanagement.controller.request.BillRequest;
import com.axonactive.coffeemanagement.service.BillDetailService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = BillDetailController.PATH)
public class BillDetailController {

    public static final String PATH = "bill_details";

    @Inject
    private BillDetailService billDetailService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(billDetailService.findAll()).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(billDetailService.findById(id)).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(BillDetailRequest billDetailRequest) {
        return Response.ok().entity(billDetailService.create(billDetailRequest)).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(BillDetailRequest billDetailRequest, @PathParam("id") Long id) {
        return Response.ok().entity(billDetailService.update(billDetailRequest, id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        return Response.ok().status(Response.Status.OK).build();
    }
}
