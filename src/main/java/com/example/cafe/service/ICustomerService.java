package com.example.cafe.service;

import java.util.List;

import javax.validation.Valid;

import com.example.cafe.dto.LoginDTO;
import com.example.cafe.dto.OrderItemDTO;
import com.example.cafe.entity.CafeCombo;
import com.example.cafe.entity.CafeItems;
import com.example.cafe.entity.CustomerOrder;
import com.example.cafe.entity.Offer;
import com.example.cafe.entity.OrderItem;

public interface ICustomerService {

	List<CafeItems> getAllItems();

	List<CafeCombo> getAllCombos();

	List<Offer> getAllOffers();

	CustomerOrder placeOrder(@Valid OrderItemDTO orderItem);

	String cancelOrder(long orderId);

	List<CustomerOrder> getCustomerOrder(String customerId);
	
}
