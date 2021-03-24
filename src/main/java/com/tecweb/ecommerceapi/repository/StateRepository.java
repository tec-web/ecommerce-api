package com.tecweb.ecommerceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecweb.ecommerceapi.model.State;

@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {
	List<State> findByCountryCode(@RequestParam("code") String code);
}
