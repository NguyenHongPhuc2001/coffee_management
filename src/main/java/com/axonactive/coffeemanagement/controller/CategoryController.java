package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.controller.request.CategoryRequest;
import com.axonactive.coffeemanagement.service.CategoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = CategoryController.PATH)
public class CategoryController {
    public static final String PATH = "/categories";

    @Inject
    private CategoryService categoryService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(categoryService.findAll()).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(categoryService.findById(id)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/name")
    public Response getByName(@QueryParam("name") String name) {
        return Response.ok().entity(categoryService.findByName(name)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/type")
    public Response getByType(@QueryParam("type") String type) {
        return Response.ok().entity(categoryService.findByType(type)).status(Response.Status.FOUND).build();
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(@Valid CategoryRequest categoryRequest) {
        return Response.ok().entity(categoryService.create(categoryRequest)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(@Valid CategoryRequest categoryRequest, @PathParam("id") Long id) {
        return Response.ok().entity(categoryService.update(categoryRequest, id)).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        categoryService.delete(id);
        return Response.ok().status(Response.Status.OK).build();
    }
}
