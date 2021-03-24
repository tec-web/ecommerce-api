package com.tecweb.ecommerceapi.dto;

import java.io.Serializable;
import java.util.Set;

import com.tecweb.ecommerceapi.model.Address;
import com.tecweb.ecommerceapi.model.Customer;
import com.tecweb.ecommerceapi.model.Order;
import com.tecweb.ecommerceapi.model.OrderItem;

public class Purchase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3445172952780007856L;
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
