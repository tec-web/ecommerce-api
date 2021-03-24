package com.tecweb.ecommerceapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tecweb.ecommerceapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByEmail(@Param("email") String email);
}
