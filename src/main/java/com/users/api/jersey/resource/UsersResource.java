package com.users.api.jersey.resource;

import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import com.users.api.jersey.model.ResponseUsers;
import com.users.api.jersey.model.Users;
import com.users.api.jersey.service.UserService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/users")
@Consumes("application/json")
@Produces("application/json")
public class UsersResource {

	@Autowired
	UserService usersService;

	// Adding User

	@Consumes("application/json")
	@Produces("application/json")
	@POST
	public Users addUser(@Valid Users user) throws URISyntaxException {

		return usersService.addUser(user);

	}

	// Updating User

	@PUT
	@Path("/{id}")

	public Users updateUser(@PathParam("id") Long uid, Users user) {

		return usersService.updateUser(uid, user);
	}

	// Deleting User

	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") Long uid) {

		boolean isUserExit = usersService.isUserExist(uid);

		if (isUserExit) {
			usersService.deleteUser(uid);

			return Response.status(200).entity("Employee is Deleted successsfully").build();
		} else {
			return Response.status(404).entity("Employee not found").build();
		}

	}

	// Fetching Users

	@GET

	public ResponseUsers getUsers(@QueryParam("searchQuery") String keyword, @QueryParam("fetchSize") int fetchSize) {

		ResponseUsers responseUsers = new ResponseUsers();

		ArrayList<Users> usersList = (ArrayList<Users>) usersService.getUsers(keyword, fetchSize);

		responseUsers.setList(usersList);

		return responseUsers;

	}

}
