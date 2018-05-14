package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Country;
import com.ivar.enterprise.ap.service.EntityService;
import com.ivar.enterprise.ap.service.EntityServiceMongoDbImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/country")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })

public class CountryResource<T> extends DefaultResource<T> {
    private EntityService<Country> service = new EntityServiceMongoDbImpl<>(Country.class,"country");
    @GET
    public Response defaultCountryGet(){
        return getResponse((T)"Country Resource default Get");
    }

    @GET
    @Path("/all")
    public Response getAllCountries(){
    	return getResponse((T)service.getEntites());
        
    }

    @GET
    @Path("/code/{code}")
    public Response getCountryByCode(@PathParam("code") String code){
        return getResponse((T)service.getEntityByCode(code));
    }

    @GET
    @Path("/id/{id}")
    public Response getCountryById(@PathParam("id") long id){
        return getResponse((T)service.getEntityById(id));
    }

    @GET
    @Path("/name/{name}")
    public Response getCountryByName(@PathParam("name") String name){
        return getResponse((T)service.getEntityByName(name));
    }
}
