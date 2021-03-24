package com.tecweb.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tecweb.ecommerceapi.model.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "ProductCategory", path = "category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
