package com.rest.home;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class FunFactClient {

    public FunFactClient(){}

    public String getFunFact(String string){
        Client client = ClientBuilder.newClient();
        URI baseURI = UriBuilder.fromUri("http://numbersapi.com/"+string.length()+"/math").build();
        WebTarget target = client.target(baseURI);
        return target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
    }
}
