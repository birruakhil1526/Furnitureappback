package org.spring.course13sp3pc1.service;

import org.spring.course13sp3pc1.domain.Products;

import org.spring.course13sp3pc1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public Products saveProducts(Products products) {
        return this.userRepository.insert(products);
    }

    @Override
    public List<Products> getAllProducts() {
        return this.userRepository.findAll();
    }

    @Override
    public String dupilcateProductsCheck(String productId) {
        if(userRepository.findById(productId).isPresent()){
           Products products= userRepository.findById(productId).get();
           if(products.getProductId().equals(productId)){
               return null;
           }
           return products.getProductId();
        }
        return productId;
    }

    @Override
    public String deleteProducts(String productId) {
        userRepository.deleteById(productId);
        return "product deleted";
    }


}
