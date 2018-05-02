package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Country;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/country")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })

public class CountryResource {
    @GET
    public String defaultCountryGet(){
        return "Country Resource default Get";
    }

    @GET
    @Path("/all")
    public List<Country> getAllCountries(){
        return new ArrayList<Country>();
    }

    @GET
    @Path("/code/{code}")
    public Country getCountryByCode(){
        return new Country();
    }

    @GET
    @Path("/id/{id}")
    public Country getCountryById(){
        return new Country();
    }
}
