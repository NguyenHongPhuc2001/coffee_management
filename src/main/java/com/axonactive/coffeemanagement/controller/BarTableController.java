package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.controller.request.BarTableRequest;
import com.axonactive.coffeemanagement.service.BarTableService;
import com.axonactive.coffeemanagement.utils.Enum.BarTableStatusEnum;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = BarTableController.PATH)
public class BarTableController {
    public static final String PATH = "/bartables";

    @Inject
    private BarTableService barTableService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(barTableService.findAll()).status(Response.Status.FOUND).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(barTableService.findById(id)).status(Response.Status.FOUND).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/table_status")
    public Response getByStatus(@QueryParam("status") String status) {
        return Response.ok().entity(barTableService.findByStatus(status)).status(Response.Status.FOUND).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(@Valid BarTableRequest barTableRequest) {
        return Response.ok().entity(barTableService.create(barTableRequest)).status(Response.Status.CREATED).build();
    }


    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(@Valid BarTableRequest barTableRequest, @PathParam("id") Long id) {
        return Response.ok().entity(barTableService.update(barTableRequest, id)).status(Response.Status.OK).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        barTableService.delete(id);
        return Response.ok().status(Response.Status.OK).build();
    }
}
