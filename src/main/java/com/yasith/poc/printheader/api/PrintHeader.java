package com.yasith.poc.printheader.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yasith on 11/21/16.
 */
@Path("/")
public class PrintHeader {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String print(@Context HttpHeaders headers) {

        MultivaluedMap<String, String> headerMap = headers.getRequestHeaders();
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, List<String>> entry : headerMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            stringBuilder.append(entry.getKey() + " : " + entry.getValue());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String printHello(){
        return "Hello";
    }
}
