package com.tecweb.ecommerceapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecweb.ecommerceapi.model.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {
	Page<Product> findByCategoryCategoryId(@RequestParam("categoryId") Integer categoryId, Pageable pageable);

	Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
