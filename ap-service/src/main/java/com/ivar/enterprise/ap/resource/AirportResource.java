package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Airport;
import com.ivar.enterprise.ap.domain.Country;
import com.ivar.enterprise.ap.service.CustomFilter;
import com.ivar.enterprise.ap.service.EntityService;
import com.ivar.enterprise.ap.service.EntityServiceMongoDbImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

@Path("/airport")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirportResource<T> extends DefaultResource<T> {
    private EntityService<Airport> service = new EntityServiceMongoDbImpl<>(Airport.class,"airport");

    @GET
    public Response defaultAirportGet(){
        return getResponse((T)"Airport Resource default Get");
    }

    @GET
    @Path("/all")
    public Response getAllAirports(){
        return getResponse((T)service.getEntites());
    }
    
    @GET
    @Path("/country/{countrycode}/")
    public Response getAllAirportsByCountryCode(@PathParam("countrycode") String countryCode){
    	 return getResponse((T)service.getEntitesByCustomFilter(new CustomFilter("isoCountry",countryCode)));
    }
    
    @GET
    @Path("/country/{countrycode}/region/{regioncode}")
    public Response getAllAirportsbyCountryCodeANDRegionCode(@PathParam("countrycode") String countryCode, 
    		@PathParam("regioncode") String regionCode){
    	List<CustomFilter> filters = Arrays.asList(new CustomFilter("isoCountry",countryCode),
    			new CustomFilter("isoRegion",regionCode));
    	 return getResponse((T)service.getEntitesByCustomFilters(filters));
    }

    @GET
    @Path("/code/{code}")
    public Response getAirportByCode(@PathParam("code") String code){
        return getResponse((T)service.getEntityByCode(code));
    }

    @GET
    @Path("/id/{id}")
    public Response getAirportById(@PathParam("id") long id){
        return getResponse((T)service.getEntityById(id));
    }

    @GET
    @Path("/name/{name}")
    public Response getAirportByName(@PathParam("name") String name){
        return getResponse((T)service.getEntityByName(name));
    }
}
