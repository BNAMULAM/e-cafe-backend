package com.example.cafe.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.dto.CafeComboDTO;
import com.example.cafe.dto.CafeItemsDTO;
import com.example.cafe.dto.LoginDTO;
import com.example.cafe.dto.OfferDTO;
import com.example.cafe.entity.CafeCombo;
import com.example.cafe.entity.CafeItems;
import com.example.cafe.entity.Login;
import com.example.cafe.entity.Offer;
import com.example.cafe.exception.AlreadyExistsException;
import com.example.cafe.exception.DoesnotExistsException;
import com.example.cafe.repository.CafeComboRepo;
import com.example.cafe.repository.CafeItemRepo;
import com.example.cafe.repository.LoginRepo;
import com.example.cafe.repository.OfferRepo;

@Service
public class ManagerServiceImpl implements IManagerService{

	@Autowired
	private CafeItemRepo cafeItemRepo;
	
	@Autowired
	private CafeComboRepo cafeComboRepo;
	
	@Autowired
	private OfferRepo offerRepo;
	
	@Autowired
	private LoginRepo loginRepo;
		
	@Override
	public String addItem(@Valid CafeItemsDTO cafeItemsDTO) throws AlreadyExistsException{
		if(cafeItemRepo.findByName(cafeItemsDTO.getName()).isEmpty()) {
			CafeItems cafeItems = new CafeItems(
					cafeItemsDTO.getName(),
					cafeItemsDTO.getDetails(),
					cafeItemsDTO.getImageUrl(),
					cafeItemsDTO.getType().toString(),	
					cafeItemsDTO.getAmount()
					);
				cafeItemRepo.save(cafeItems);
				return "Item Added Sccessfully";
		}
		else {
			throw new AlreadyExistsException("Item with same name already Exists");
		}
	}

	@Override
	public String updateItem(long itemId, @Valid CafeItemsDTO cafeItemsDTO) throws DoesnotExistsException {
		if(cafeItemRepo.findById((long)itemId).isPresent()) {
			CafeItems cafeItems = new CafeItems(
					cafeItemsDTO.getName(),
					cafeItemsDTO.getDetails(),
					cafeItemsDTO.getImageUrl(),
					cafeItemsDTO.getType().toString(),	
					cafeItemsDTO.getAmount()
					);
			cafeItems.setId((long)itemId);
			cafeItemRepo.save(cafeItems);
			return "Item Updated Sccessfully";
		}
		else {
			throw new DoesnotExistsException("Item Doesn't Exists");
		}
	}

	@Override
	public String deleteItem(long itemId)  throws DoesnotExistsException {

		if(cafeItemRepo.findById(itemId).isPresent()) {
			cafeItemRepo.deleteById(itemId);
			return "Item Deleted Sccessfully";
		}
		else {
			throw new DoesnotExistsException("Item Doesn't Exists");
		}
	}

	@Override
	public List<CafeItems> getAllItems() {
		return cafeItemRepo.findAll();
	}

	@Override
	public String addCombo(@Valid CafeComboDTO cafeComboDTO) throws AlreadyExistsException{
		if(cafeComboRepo.findByName(cafeComboDTO.getName()).isEmpty()) {
		CafeCombo cafeCombo = new CafeCombo(
				cafeComboDTO.getName(),
				cafeComboDTO.getDetails(),
				cafeComboDTO.getImageUrl(),
				cafeComboDTO.getType().toString(),
				cafeComboDTO.getAmount()
				);
			cafeComboRepo.save(cafeCombo);
			return "Combo Added Sccessfully";
		}
		else {
			throw new AlreadyExistsException("Combo with same name already Exists");
		}
		
	}

	@Override
	public String updateCombo(long comboId, @Valid CafeComboDTO cafeComboDTO)  throws DoesnotExistsException{
		if(cafeComboRepo.findById(comboId).isPresent()) {
			CafeCombo cafeCombo = new CafeCombo(
					cafeComboDTO.getName(),
					cafeComboDTO.getDetails(),
					cafeComboDTO.getImageUrl(),
					cafeComboDTO.getType().toString(),	
					cafeComboDTO.getAmount()
					);
			cafeCombo.setId(comboId);
			cafeComboRepo.save(cafeCombo);
			return "Combo Updated Sccessfully";
		}
		else {
			throw new DoesnotExistsException("Combo Doesn't Exists");
		}
	}

	@Override
	public String deleteCombo(long comboId)  throws DoesnotExistsException{
		if(cafeComboRepo.findById(comboId).isPresent()) {
			cafeComboRepo.deleteById(comboId);
			return "Combo delete Sccessfully";
		}
		else {
			throw new DoesnotExistsException("Combo Doesn't Exists");
		}
	}

	@Override
	public List<CafeCombo> getAllCombo() {
		// TODO Auto-generated method stub
		return cafeComboRepo.findAll();
	}

	@Override
	public String addOffer(@Valid OfferDTO offerDTO) throws AlreadyExistsException{
		if(offerRepo.findById(offerDTO.getOfferCode()).isEmpty()) {
		Offer offer = new Offer(
				offerDTO.getOfferCode(),
				offerDTO.getOfferType().toString(),
				offerDTO.getDetails(),
				offerDTO.isEnabeled(),
				offerDTO.getDate(),
				offerDTO.getOfferValue()
				);
			offerRepo.save(offer);
			return "Offer Added Sccessfully";
		}
		else{
			throw new AlreadyExistsException("Order with same code already Exists");
		}
	}

	@Override
	public String updateOffer(String offerCode, @Valid OfferDTO offerDTO)  throws DoesnotExistsException {
		if(offerRepo.findById(offerCode).isPresent()) {
			Offer offer = new Offer(
					offerDTO.getOfferCode(),
					offerDTO.getOfferType().toString(),
					offerDTO.getDetails(),
					offerDTO.isEnabeled(),
					offerDTO.getDate(),
					offerDTO.getOfferValue()
					);
			offer.setOfferCode(offerCode);
			offerRepo.save(offer);
			return "Offer Updated Sccessfully";
		}
		else {
			throw new DoesnotExistsException("Offer Doesn't Exists");
		}
	}

	@Override
	public String deleteOffer(String offerCode)  throws DoesnotExistsException{
		if(offerRepo.findById(offerCode).isPresent()) {
			offerRepo.deleteById(offerCode);
			return "Offer Deleted Sccessfully";
		}
		else {
			throw new DoesnotExistsException("Offer Doesn't Exists");
		}
	}

	@Override
	public List<Offer> getAllOffer() {
		return offerRepo.findAll();
	}

	@Override
	public String registerManager(@Valid LoginDTO loginDTO) {
		if(loginRepo.findById(loginDTO.getUserName()).isEmpty()) {
			Login login = new Login(
					loginDTO.getUserName(),
					loginDTO.getPassword(),
					"MANAGER",
					loginDTO.getMobileNumber());
			loginRepo.save(login);
			return "Registered";
		}
		else {
			throw new AlreadyExistsException("User with Similar username already exists");
		}
	}

	@Override
	public String loginManager(String userName, String password) {
		// TODO Auto-generated method stub
		Optional<Login> loginObj = loginRepo.findById(userName);
		if(loginObj.isPresent() && loginObj.get().getPassword().equals(password)) {
			return "Success";
		}
		return "failed";
	}
	
	
}
