package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping(path = "products")
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/get")
    public List<Product> list() {
        return service.listAll();
    }
    
    // RESTful API method for Create operation
     
    
	@PostMapping("/add")
	public void createProduct(@RequestBody Product pro) {
		service.save(pro);
	}
    
    // RESTful API method for Update operation
     
	@PutMapping("/{id}")
	public void updateProduct(@RequestBody Product renew) {
	 service.save(renew);
	}
	

	}
