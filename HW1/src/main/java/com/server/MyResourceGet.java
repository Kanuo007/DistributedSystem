package com.server;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("myresourceGet")
public class MyResourceGet {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getStatus() {
        return ("alive");
    }
}