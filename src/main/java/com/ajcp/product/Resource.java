package com.ajcp.product;

import com.ajcp.product.entity.Product;
import com.ajcp.product.repository.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class Resource {

    @Inject
    ProductRepository productRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> hello() {
        return productRepository.getProducts();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Product product) {
        productRepository.save(product);
        return Response.ok().build();
    }

    @DELETE
    public Response delete(Product product) {
        productRepository.remove(product);
        return Response.ok().build();
    }

}