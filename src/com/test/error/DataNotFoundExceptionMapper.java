package com.test.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.test.beans.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage=new ErrorMessage("Fail", ex.getMessage(), 12);
		String json = new Gson().toJson(errorMessage);
		return Response.status(Status.NOT_FOUND).entity(json).build();
	}

}
