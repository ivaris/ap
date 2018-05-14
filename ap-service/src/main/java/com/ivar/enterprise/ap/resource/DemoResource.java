package com.ivar.enterprise.ap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demo")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class DemoResource<T> extends DefaultResource<T> {
    @GET
    public Response defaultDemoGet(){
        return getResponse((T)"Demo Resource default Get");
    }
}
