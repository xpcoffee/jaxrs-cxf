package jaxrs.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces({ MediaType.TEXT_PLAIN })
public class BasicApi {

    @GET
    @Path("/")
    public Response sayHello() {
        return Response.status(Response.Status.OK).entity("<h1>Hello, world!</h1>").build();
    }
}
