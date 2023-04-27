package com.example.cafe.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.dto.LoginDTO;
import com.example.cafe.dto.OrderItemDTO;
import com.example.cafe.entity.CafeCombo;
import com.example.cafe.entity.CafeItems;
import com.example.cafe.entity.CustomerOrder;
import com.example.cafe.entity.Offer;
import com.example.cafe.entity.OrderItem;
import com.example.cafe.service.ICustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	ICustomerService iCustomerService;
	
	@GetMapping("/allItems")	
	public List<CafeItems>  getAllItems(){
		
		return iCustomerService.getAllItems();
	}
	@GetMapping("/allCombos")	
	public List<CafeCombo>  getAllCombos(){
		
		return iCustomerService.getAllCombos();
	}
	@GetMapping("/allOffers")	
	public List<Offer>  getAllOffers(){
		
		return iCustomerService.getAllOffers();
	}
	
	@PostMapping("/placeOrder")
	public CustomerOrder placeOrder(@Valid @RequestBody OrderItemDTO orderItem) {		
		return iCustomerService.placeOrder(orderItem);
	}
	
	@PostMapping("/cancelOrder/{orderId}")
	public String cancelOrder(@PathVariable long orderId) {
		
		return iCustomerService.cancelOrder(orderId);
	}
	
	@GetMapping("/getAllOrders/{userName}")
	public List<CustomerOrder> getCustomerOrder(@PathVariable String userName) {
		return iCustomerService.getCustomerOrder(userName);
	}
	
}
