package com.ivar.enterprise.ap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/airportfrequency")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirportFrequencyResource {
    @GET
    public String defaultAirportFrequencyGet(){
        return "Airport Frequency Resource default Get";
    }
}
