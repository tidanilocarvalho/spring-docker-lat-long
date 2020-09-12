package com.danilo.springboot.docker.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.danilo.springboot.docker.exception.LatLongException;
import com.danilo.springboot.docker.service.Address;

@Service
public class AddressImpl implements Address
{
    
    private final URIBuilder uriBuilder = new URIBuilder();
    private final CloseableHttpClient httpclient = HttpClients.createDefault();
    
    public String getAddress(String city, String state, String amenity) {
        try
        {
            URI uri = uriBuilder.setScheme("https")
                .setHost("nominatim.openstreetmap.org")
                .setPath("/search")
                .setParameter("format", "json")
                .setParameter("addressdetails", "1")
                .setParameter("city", city)
                .setParameter("state", state)
                .setParameter("amenity", amenity)
                .build();
            
            HttpGet httpGet = new HttpGet(uri);
            
            return EntityUtils.toString(httpclient.execute(httpGet).getEntity());
        }
        catch (URISyntaxException | ParseException | IOException e)
        {
            throw new LatLongException("Error during search at OSM", e);
        }
    }

}
