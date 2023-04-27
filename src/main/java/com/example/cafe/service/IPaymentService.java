package com.example.cafe.service;

import java.util.List;

import javax.validation.Valid;

import com.example.cafe.dto.PaymentDTO;
import com.example.cafe.entity.Payment;

public interface IPaymentService {

	String payBill(@Valid PaymentDTO paymentDTO);

	List<Payment> getPayment(String orderId);

}
