package com.ajcp.product.repository;

import com.ajcp.product.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void save(Product p) {
        em.persist(p);
    }

    @Transactional
    public void remove(Product p) {
        em.remove(p);
    }

    @Transactional
    public List<Product> getProducts() {
        List<Product> products = em.createQuery("select p from Product p").getResultList();
        return products;
    }

}
