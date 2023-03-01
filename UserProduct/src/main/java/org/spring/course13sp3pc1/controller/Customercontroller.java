package org.spring.course13sp3pc1.controller;

import org.spring.course13sp3pc1.domain.Products;

import org.spring.course13sp3pc1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Customercontroller {
    @Autowired
    private UserService userService;

    @GetMapping("products")
    public ResponseEntity<?> getAllProducts(){
//       List<Customer> list=customerservice.getAllCustomers();
//       return new ResponseEntity<>(list,HttpStatus.OK);

      return new ResponseEntity<>(userService.getAllProducts(),HttpStatus.OK);
    }
//    @PostMapping("register")
//    public ResponseEntity<?> save(@RequestBody Userr userr){
//        return new ResponseEntity<>(userService.registerUser(userr),HttpStatus.OK);
//    }
    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Products products){
        System.out.println(products.getTitle1());
        String checking=userService.dupilcateProductsCheck(products.getProductId());
        if(checking!=null) {
            return new ResponseEntity<>(userService.saveProducts(products), HttpStatus.OK);
        }
        return new ResponseEntity<>("Product already exists",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("delete/{productId}")
    public ResponseEntity<?> delete(@PathVariable String productId){
        return new ResponseEntity<>(userService.deleteProducts(productId),HttpStatus.OK);
    }
}
