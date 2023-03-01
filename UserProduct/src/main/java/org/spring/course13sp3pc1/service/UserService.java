package org.spring.course13sp3pc1.service;

import org.spring.course13sp3pc1.domain.Products;


import java.util.List;

public interface UserService {
    Products saveProducts(Products products);


    List<Products> getAllProducts();
    String dupilcateProductsCheck(String productId);
    String deleteProducts(String productId);

}
