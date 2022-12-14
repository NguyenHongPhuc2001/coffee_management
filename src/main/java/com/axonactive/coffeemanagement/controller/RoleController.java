package com.axonactive.coffeemanagement.controller;


import com.axonactive.coffeemanagement.service.RoleService;
import com.axonactive.coffeemanagement.service.dto.RoleDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = RoleController.PATH)
public class RoleController {
    public static final String PATH = "/roles";

    @Inject
    private RoleService roleService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(roleService.findAll()).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(roleService.findById(id)).status(Response.Status.FOUND).build();
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(@Valid RoleDto roleRequest) {
        return Response.ok().entity(roleService.create(roleRequest)).status(Response.Status.CREATED).build();
    }


    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(@Valid RoleDto roleRequest, @PathParam("id") Long id) {
        return Response.ok().entity(roleService.update(roleRequest, id)).status(Response.Status.OK).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        roleService.deleteById(id);
        return Response.ok().status(Response.Status.OK).build();
    }
}
