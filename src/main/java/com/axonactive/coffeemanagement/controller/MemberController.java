package com.axonactive.coffeemanagement.controller;

import com.axonactive.coffeemanagement.service.MemberService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path(value = MemberController.PATH)
public class MemberController {

    public static final String PATH = "/members";

    @Inject
    private MemberService memberService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(memberService.findAll()).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return Response.ok().entity(memberService.findById(id)).status(Response.Status.FOUND).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/memberPhone")
    public Response getByMemberPhone(@QueryParam("memberPhone") String memberPhone) {
        return Response.ok().entity(memberService.findByMemberPhone(memberPhone)).status(Response.Status.FOUND).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(@Valid MemberRequest memberRequest) {
        return Response.ok().entity(memberService.create(memberRequest)).status(Response.Status.CREATED).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Response update(@Valid MemberRequest memberRequest, @PathParam("id") Long id) {
        return Response.ok().entity(memberService.update(memberRequest, id)).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        memberService.delete(id);
        return Response.ok().status(Response.Status.OK).build();
    }

}
