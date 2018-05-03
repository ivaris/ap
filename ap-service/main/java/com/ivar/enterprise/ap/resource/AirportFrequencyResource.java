package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Airport;
import com.ivar.enterprise.ap.domain.AirportFrequency;
import com.ivar.enterprise.ap.service.EntityService;
import com.ivar.enterprise.ap.service.EntityServiceMongoDbImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/airportfrequency")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirportFrequencyResource {
    private EntityService<AirportFrequency> service = new EntityServiceMongoDbImpl<>(AirportFrequency.class,"airportfrequency");

    @GET
    public String defaultAirportFrequencyGet(){
        return "Airport Frequency Resource default Get";
    }

    @GET
    @Path("/all")
    public List<AirportFrequency> getAllAirportFrequencies(){
        return service.getEntites();
    }

    @GET
    @Path("/code/{code}")
    public AirportFrequency getAirportFrequencyByCode(@PathParam("code") String code){
        return service.getEntityByCode(code);
    }

    @GET
    @Path("/id/{id}")
    public AirportFrequency getAirportFrequencyById(@PathParam("id") long id){
        return service.getEntityById(id);
    }

    @GET
    @Path("/name/{name}")
    public AirportFrequency getAirportFrequencyByName(@PathParam("name") String name){
        return service.getEntityByName(name);
    }

}
