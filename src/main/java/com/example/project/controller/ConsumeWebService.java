package com.example.project.controller;

import com.example.project.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/externalWebAPIGET")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://cataas.com/api/tags", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/externalWebAPIPOST", method = RequestMethod.POST)
    public String createProducts(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
        return restTemplate.exchange(
                "http://localhost:8087/product", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/externalWebAPIPUT/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
        return restTemplate.exchange(
                "http://localhost:8087/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/externalWebAPIDELETE/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);

        return restTemplate.exchange(
                "http://localhost:8087/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}