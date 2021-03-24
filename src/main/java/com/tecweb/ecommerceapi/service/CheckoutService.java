package com.tecweb.ecommerceapi.service;

import com.tecweb.ecommerceapi.dto.Purchase;
import com.tecweb.ecommerceapi.dto.PurchaseResponse;

public interface CheckoutService {
	PurchaseResponse placeOrder(Purchase purchase);
}
