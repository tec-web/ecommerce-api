package com.tecweb.ecommerceapi.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name = "order_tracking_number")
	private String orderTrackingNumber;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@Column(name="total_quantity")
	private Integer totalQuantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="billing_address_id", referencedColumnName = "address_id")
	private Address billingAddress;
	
	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id", referencedColumnName = "address_id") 
	private Address shippingAddress;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "date_created")
	@CreationTimestamp	
	private LocalDate dateCreated;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private LocalDate lastUpdated;
	
	@OneToMany(mappedBy = "order", cascade= CascadeType.ALL)
	private Set<OrderItem> orderItems; 
	
	public Order() {		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void addOrderItem(OrderItem orderItem) {		
		if(orderItem != null) {
			if(orderItems == null) {
				orderItems = new HashSet<OrderItem>();
			}						
			orderItem.setOrder(this);
			orderItems.add(orderItem);
		}
	}
}
