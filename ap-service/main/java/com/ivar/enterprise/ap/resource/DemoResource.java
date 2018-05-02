package com.ivar.enterprise.ap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class DemoResource {
    @GET
    @Path("/")
    public String defaultGet(){
        return "Demo Resource default Get";
    }
}
