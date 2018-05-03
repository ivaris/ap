package com.ivar.enterprise.ap.resource;

import com.ivar.enterprise.ap.domain.Country;
import com.ivar.enterprise.ap.domain.Region;
import com.ivar.enterprise.ap.service.EntityService;
import com.ivar.enterprise.ap.service.EntityServiceMongoDbImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/region")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class RegionResource {
    private EntityService<Region> service = new EntityServiceMongoDbImpl<>(Region.class,"region");

    @GET
    public String defaultRegionGet(){
        return "Region Resource default Get";
    }

    @GET
    @Path("/all")
    public List<Region> getAllRegions(){
        return service.getEntites();
    }

    @GET
    @Path("/code/{code}")
    public Region getRegionByCode(@PathParam("code") String code){
        return service.getEntityByCode(code);
    }

    @GET
    @Path("/id/{id}")
    public Region getRegionById(@PathParam("id") long id){
        return service.getEntityById(id);
    }

    @GET
    @Path("/name/{name}")
    public Region getRegionByName(@PathParam("name") String name){
        return service.getEntityByName(name);
    }
}
