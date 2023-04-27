package com.example.cafe;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.cafe.dto.OrderItemDTO;
import com.example.cafe.entity.CustomerOrder;
import com.example.cafe.entity.Login;
import com.example.cafe.service.CustomerServiceImpl;
import com.example.cafe.service.LoginServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerTest {
	
	@Mock
	CustomerServiceImpl customerServiceImpl;
	
	@Mock
	LoginServiceImpl loginServiceImpl;
	
	@Test
	void placeOrderTest () {
		OrderItemDTO orderItemDTO = new OrderItemDTO(true,1,"m@m.m",true,"SALE50");
		CustomerOrder obj = new CustomerOrder();
		when(customerServiceImpl.placeOrder(orderItemDTO)).thenReturn(obj);
		assertEquals(customerServiceImpl.placeOrder(orderItemDTO),obj);
	}
	@Test
	void cancelOrderTest () {

		when(customerServiceImpl.cancelOrder(123)).thenReturn("Order Cancelled");
		assertEquals(customerServiceImpl.cancelOrder(123),"Order Cancelled");
	}
	@Test
	void loginCustomerTest () {
		Login obj = new Login();
		when(loginServiceImpl.login("USER1","PASS")).thenReturn(obj);
		assertEquals(loginServiceImpl.login("USER1","PASS"),obj);
	}
}
