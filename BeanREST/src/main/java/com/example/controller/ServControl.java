package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.*;

//The @RestController annotation is used to define the RESTful web services

@RestController
public class ServControl {

	private static Map<String, Product> repo = new HashMap<>();

	static {
		Product hon = new Product();
		hon.setId("1");
		hon.setName("Honey");

		repo.put(hon.getId(), hon);

		Product al = new Product();
		al.setId("2");
		al.setName("Almond");

		repo.put(al.getId(), al);

	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		repo.remove(id);

		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)

	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {

		repo.remove(id);

		product.setId(id);

		repo.put(id, product);

		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)

	public ResponseEntity<Object> createProduct(@RequestBody Product product) {

		repo.put(product.getId(), product);

		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products")

	public ResponseEntity<Object> getProduct() {

		return new ResponseEntity<>(repo.values(), HttpStatus.OK);
	}
}
