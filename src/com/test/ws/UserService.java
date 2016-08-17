package com.test.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.test.beans.User;
import com.test.business.UserBusiness;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserService {

	UserBusiness userservice = new UserBusiness();

	// Return all the users
	@GET
	public Response getUser(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("end") int end) {
		String json = null;
		List<User> userOutput;
		if (year > 0) {
			userOutput = userservice.getAllUserForYear(year);
		} else {
			userOutput = userservice.getAllUser();
		}
		if (start >= 0 && end > 0) {

			userOutput = userservice.getAllUsersPagination(start, end);
		}
		json = new Gson().toJson(userOutput);
		return Response.status(Status.OK).entity(json).build();
	}

	// Return particular user
	@GET
	@Path("/{userId}")
	public Response getUser(@PathParam("userId") long userId) {
		String json = new Gson().toJson(userservice.getUser(userId));
		return Response.status(Status.OK).entity(json).build();
	}

	// Insert new user and return it
	@Path("/insert")
	@POST
	public Response addUser(String msg) {
		Gson gson = new Gson();
		User user = gson.fromJson(msg, User.class);
		userservice.addUser(user);
		String json = new Gson().toJson(userservice.getUser(user.getId()));
		return Response.status(Status.CREATED).entity(json).build();
	}

	// Update existing user and return updated user
	@Path("/update/{userId}")
	@PUT
	public Response updateUser(@PathParam("userId") long userId, String msg) {
		Gson gson = new Gson();
		User user = gson.fromJson(msg, User.class);
		user.setId(userId);
		userservice.updateUser(user);
		String json = new Gson().toJson(userservice.getUser(user.getId()));
		return Response.status(Status.OK).entity(json).build();
	}

	// Delete existing user
	@Path("/delete/{userId}")
	@DELETE
	public Response deleteUser(@PathParam("userId") long userId) {
		userservice.removeUser(userId);
		return Response.status(Status.OK).entity("User Removed ...").build();
	}

	// Get address of user
	@Path("/{userId}/address")
	public UserAddressService getUserAddressService() {
		return new UserAddressService();
	}
}
