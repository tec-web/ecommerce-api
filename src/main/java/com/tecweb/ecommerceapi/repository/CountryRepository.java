package com.tecweb.ecommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tecweb.ecommerceapi.model.Country;

@RepositoryRestResource(collectionResourceRel = "countries", path = "country")
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
