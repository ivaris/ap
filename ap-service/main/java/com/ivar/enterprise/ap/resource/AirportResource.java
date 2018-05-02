package com.ivar.enterprise.ap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/airport")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirportResource {
    @GET
    public String defaultAirportGet(){
        return "Airport Resource default Get";
    }
}
