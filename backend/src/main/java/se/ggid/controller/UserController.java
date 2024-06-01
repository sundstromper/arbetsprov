package se.ggid.controller;

import org.jboss.logging.Logger;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.ggid.service.UserService;
import se.ggid.dto.UserDto;


@Path("/ggid/user")
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class);

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        LOG.info("Hämtar alla users");
        return Response
                .ok(userService.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDto userDto) {
        LOG.info("Sparar en ny person, " + userDto.toString());
        return Response
                .ok(userService.addUser(userDto))
                .build();
    }




}
