package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Airport;
import com.ivar.enterprise.ap.domain.Country;
import com.ivar.enterprise.ap.service.EntityService;
import com.ivar.enterprise.ap.service.EntityServiceMongoDbImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/airport")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirportResource {
    private EntityService<Airport> service = new EntityServiceMongoDbImpl<>(Airport.class,"airport");

    @GET
    public String defaultAirportGet(){
        return "Airport Resource default Get";
    }

    @GET
    @Path("/all")
    public List<Airport> getAllAirports(){
        return service.getEntites();
    }

    @GET
    @Path("/code/{code}")
    public Airport getAirportByCode(@PathParam("code") String code){
        return service.getEntityByCode(code);
    }

    @GET
    @Path("/id/{id}")
    public Airport getAirportById(@PathParam("id") long id){
        return service.getEntityById(id);
    }

    @GET
    @Path("/name/{name}")
    public Airport getAirportByName(@PathParam("name") String name){
        return service.getEntityByName(name);
    }
}
