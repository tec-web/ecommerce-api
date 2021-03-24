package com.tecweb.ecommerceapi.service;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tecweb.ecommerceapi.dto.Purchase;
import com.tecweb.ecommerceapi.dto.PurchaseResponse;
import com.tecweb.ecommerceapi.model.Customer;
import com.tecweb.ecommerceapi.model.Order;
import com.tecweb.ecommerceapi.repository.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	CustomerRepository customerRepository;

	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		String orderTrackingNumber = generateOrderTrackingNumber();

		Order order = purchase.getOrder();
		order.setOrderTrackingNumber(orderTrackingNumber);
		purchase.getOrderItems().stream().forEach(order::addOrderItem);
		order.setShippingAddress(purchase.getShippingAddress());
		order.setBillingAddress(purchase.getBillingAddress());

		Optional<Customer> optCustomer = customerRepository.findByEmail(purchase.getCustomer().getEmail());
		Customer customer = optCustomer.orElse(purchase.getCustomer());
		
		customer.addOrder(order);
		customerRepository.save(customer);
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		return UUID.randomUUID().toString();
	}
}
