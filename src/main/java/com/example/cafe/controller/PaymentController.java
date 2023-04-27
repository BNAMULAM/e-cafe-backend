package com.example.cafe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.dto.PaymentDTO;
import com.example.cafe.entity.Payment;
import com.example.cafe.service.IPaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
	@Autowired
	private IPaymentService iPaymentService;
	
	@PostMapping("/payBill")
	private String payBill(@RequestBody @Valid PaymentDTO paymentDTO ) {
		return iPaymentService.payBill(paymentDTO);
	}
	
	@GetMapping("/getPayment/{userName}")
	private List<Payment> getPayment(@PathVariable String userName) {
		return iPaymentService.getPayment(userName);
	}
	
}
