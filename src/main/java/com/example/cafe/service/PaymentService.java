package com.example.cafe.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.dto.PaymentDTO;
import com.example.cafe.entity.Payment;
import com.example.cafe.repository.PaymentRepo;

@Service
public class PaymentService implements IPaymentService {

	@Autowired
	PaymentRepo paymentRepo;
	
	@Override
	public String payBill(@Valid PaymentDTO paymentDTO) {
		if(paymentRepo.findByOrderId(paymentDTO.getOrderId()).isEmpty()) {
			Payment payment = new Payment(
					paymentDTO.getCustomerId(),
					paymentDTO.getOrderId(),
					paymentDTO.getStatus().toString(),
					paymentDTO.getAmount(),
					paymentDTO.getPaidBy().toString());
			try {
				paymentRepo.save(payment);
				return "Payment Added Succesfully";
			}
			catch(Exception e) {
				return "Payment Adding Failed";
			}
		}
		else {
			return "Payment for this order was already made";
		}
	}

	@Override
	public List<Payment> getPayment(String userName) {
		// TODO Auto-generated method stub
		return paymentRepo.findByCustomerId(userName);
	}

}
