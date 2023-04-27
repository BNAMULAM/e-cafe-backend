package com.example.cafe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.dto.LoginDTO;
import com.example.cafe.dto.OrderItemDTO;
import com.example.cafe.entity.CafeCombo;
import com.example.cafe.entity.CafeItems;
import com.example.cafe.entity.CustomerOrder;
import com.example.cafe.entity.Login;
import com.example.cafe.entity.Offer;
import com.example.cafe.entity.OrderItem;
import com.example.cafe.exception.AlreadyExistsException;
import com.example.cafe.exception.DoesnotExistsException;
import com.example.cafe.repository.CafeComboRepo;
import com.example.cafe.repository.CafeItemRepo;
import com.example.cafe.repository.CustomerOrderRepo;
import com.example.cafe.repository.LoginRepo;
import com.example.cafe.repository.OfferRepo;
import com.example.cafe.repository.OrderItemRepo;
import com.example.cafe.repository.PaymentRepo;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CafeItemRepo cafeItemRepo;
	
	@Autowired
	private CafeComboRepo cafeComboRepo;
	
	@Autowired
	private OfferRepo offerRepo;
	
	@Autowired
	private OrderItemRepo orderItemRepo;
	
	@Autowired
	private PaymentRepo paymentRepo; 
	
	@Autowired
	private CustomerOrderRepo customerOrderRepo; 
	
	@Override
	public List<CafeItems> getAllItems() {
		return cafeItemRepo.findAll();
	}

	@Override
	public List<CafeCombo> getAllCombos() {
		// TODO Auto-generated method stub
		return cafeComboRepo.findAll();
	}

	@Override
	public List<Offer> getAllOffers() {
		// TODO Auto-generated method stub
		return offerRepo.findAll();
	}

	

	@Override
	public CustomerOrder placeOrder(@Valid OrderItemDTO orderItem) throws DoesnotExistsException{
		OrderItem orderItemObj;
		if(orderItem.isCombo()) {
			Optional<CafeCombo> obj =  cafeComboRepo.findById(orderItem.getItemId());
			if(obj.isEmpty()) {
				throw new DoesnotExistsException("Item doesn't exists with this ID Order not placed");
			}
			orderItemObj = new OrderItem(
					orderItem.getItemId(),
					orderItem.isCombo(),
					orderItem.getQuantiy(),
					obj.get().getAmount() * orderItem.getQuantiy()
					);
		}
		else {
			Optional<CafeItems> obj =  cafeItemRepo.findById(orderItem.getItemId());
			if(obj.isEmpty()) {
				throw new DoesnotExistsException("Item doesn't exists with this ID Order not placed");
			}
			orderItemObj = new OrderItem(
					orderItem.getItemId(),
					orderItem.isCombo(),
					orderItem.getQuantiy(),
					obj.get().getAmount() * orderItem.getQuantiy()
					);
		}

		double totalAmount = orderItemObj.getAmount();
		double tax =  ((totalAmount*18)/100);
		totalAmount+=tax;
		double final_amount =totalAmount;
		String offerCode = orderItem.getOfferCode();
		if(orderItem.isOfferApplied()) {
			Optional<Offer> offerObj = offerRepo.findById(offerCode);
			boolean isOfferApplied;
			if(offerObj.isPresent()) {
				isOfferApplied=true;
				String type = offerObj.get().getOfferType().toString();
				if(type.equalsIgnoreCase("DISCOUNT_AMOUNT")) {
					final_amount-=offerObj.get().getOfferValue();
				}
				else {
					final_amount-= ((final_amount*offerObj.get().getOfferValue())/100);
				}
			}
			else {
				isOfferApplied=false;
				offerCode=null;
			}
		}
		List<OrderItem> orderItemList = new ArrayList<>();
		orderItemList.add(orderItemObj);
		CustomerOrder customerOrder = new CustomerOrder(
				orderItemList,
				orderItem.getUserName(),
				orderItem.isOfferApplied(),
				offerCode,
				tax,
				totalAmount,
				final_amount);
		return customerOrderRepo.save(customerOrder);
	}

	@Override
	public String cancelOrder(long orderId) {
		if(customerOrderRepo.findById(orderId).isPresent()){
			customerOrderRepo.deleteById(orderId);
			return "Order Cancelled";
		}

		throw new DoesnotExistsException("Order doesnot exists with this ID");
	}

	@Override
	public List<CustomerOrder> getCustomerOrder(String customerId) {
		// TODO Auto-generated method stub
		return customerOrderRepo.findByUserName(customerId);
	}


}
