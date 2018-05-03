package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Country;
import com.ivar.enterprise.ap.service.EntityService;
import com.ivar.enterprise.ap.service.EntityServiceMongoDbImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/country")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })

public class CountryResource {
    private EntityService<Country> service = new EntityServiceMongoDbImpl<>(Country.class,"country");
    @GET
    public String defaultCountryGet(){
        return "Country Resource default Get";
    }

    @GET
    @Path("/all")
    public List<Country> getAllCountries(){
        return service.getEntites();
    }

    @GET
    @Path("/code/{code}")
    public Country getCountryByCode(@PathParam("code") String code){
        return service.getEntityByCode(code);
    }

    @GET
    @Path("/id/{id}")
    public Country getCountryById(@PathParam("id") long id){
        return service.getEntityById(id);
    }

    @GET
    @Path("/name/{name}")
    public Country getCountryByName(@PathParam("name") String name){
        return service.getEntityByName(name);
    }
}
