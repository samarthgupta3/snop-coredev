package com.smartNodeProtocol.web.rest;

import com.google.inject.Inject;
import com.smartNodeProtocol.core.dao.model.data.user.User;
import com.smartNodeProtocol.core.service.user.intf.UserManagementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
/**
 * Created by Samarth on 06-10-2017.
 */
@Path("/users")
public class UserRestService {

    private final UserManagementService userManagementService;

    @Inject
    public UserRestService(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @GET
    @Path("numberOfUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNumberOfUsers() {
        return userManagementService.getNumberOfUsers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsersInJSON() {
        return userManagementService.getAllUsers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id) {
        return userManagementService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return userManagementService.createNewUser(user);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user) {
        return userManagementService.update(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") Long id) {
        userManagementService.remove(id);
    }
}
