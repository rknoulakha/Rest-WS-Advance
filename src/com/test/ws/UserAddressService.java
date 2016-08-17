package com.test.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.test.business.UserBusiness;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UserAddressService {

	UserBusiness userservice = new UserBusiness();

	@GET
	@Path("/view")	
	public Response getUserAddress(@PathParam("userId") long userId) {
		String json = new Gson().toJson(userservice.getUserAddress(userId));
		return Response.status(Status.OK).entity(json).build();
	}
	
}
