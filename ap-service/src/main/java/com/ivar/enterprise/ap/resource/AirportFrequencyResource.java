package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Airport;
import com.ivar.enterprise.ap.domain.AirportFrequency;
import com.ivar.enterprise.ap.service.EntityService;
import com.ivar.enterprise.ap.service.EntityServiceMongoDbImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.annotation.JSONP.Def;

import java.util.List;

@Path("/airportfrequency")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirportFrequencyResource<T> extends DefaultResource<T> {
    private EntityService<AirportFrequency> service = new EntityServiceMongoDbImpl<>(AirportFrequency.class,"airportfrequency");

    @GET
    public Response defaultAirportFrequencyGet(){
        return getResponse((T)"Airport Frequency Resource default Get");
    }

    @GET
    @Path("/all")
    public Response getAllAirportFrequencies(){
        return getResponse((T)service.getEntites());
    }

    @GET
    @Path("/code/{code}")
    public Response getAirportFrequencyByCode(@PathParam("code") String code){
        return getResponse((T)service.getEntityByCode(code));
    }

    @GET
    @Path("/id/{id}")
    public Response getAirportFrequencyById(@PathParam("id") long id){
        return getResponse((T)service.getEntityById(id));
    }

    @GET
    @Path("/name/{name}")
    public Response getAirportFrequencyByName(@PathParam("name") String name){
        return getResponse((T)service.getEntityByName(name));
    }

}
