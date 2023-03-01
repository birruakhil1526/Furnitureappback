package org.spring.course13sp3pc1.repository;


import org.spring.course13sp3pc1.domain.Products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Products,String> {

}
