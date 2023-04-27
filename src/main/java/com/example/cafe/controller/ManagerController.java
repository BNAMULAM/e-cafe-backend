package com.example.cafe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.dto.CafeComboDTO;
import com.example.cafe.dto.CafeItemsDTO;
import com.example.cafe.dto.LoginDTO;
import com.example.cafe.dto.OfferDTO;
import com.example.cafe.entity.CafeCombo;
import com.example.cafe.entity.CafeItems;
import com.example.cafe.entity.Offer;
import com.example.cafe.exception.AlreadyExistsException;
import com.example.cafe.service.IManagerService;

@RestController
@RequestMapping("/Manager")
public class ManagerController {
	
	@Autowired
	private IManagerService iManagerService;
	
	//Items CRUD
	@PostMapping("/addItem")
	public String addItem(@RequestBody @Valid CafeItemsDTO cafeItemsDTO) {
		try {
			return iManagerService.addItem(cafeItemsDTO);
		} catch (AlreadyExistsException e) {
			return "Item Couldnot be added err-> "+e.getMessage() ;
		}
	}
	
	@PutMapping("/updateItem/{itemId}")
	public String updateItem(@PathVariable long itemId,@RequestBody @Valid CafeItemsDTO cafeItemsDTO) {
		return iManagerService.updateItem(itemId,cafeItemsDTO);
	}
	@DeleteMapping("/deleteItem/{itemId}")
	public String deleteItem(@PathVariable long itemId) {
		
		return iManagerService.deleteItem(itemId);
	}
	@GetMapping("/getAllItems")	
	public List<CafeItems>  getAllItems(){
		return iManagerService.getAllItems();
	}
	
	//Combos CRUD
	@PostMapping("/addCombo")
	public String addCombo(@RequestBody @Valid CafeComboDTO cafeComboDTO) {
		return iManagerService.addCombo(cafeComboDTO);
	}
	
	@PutMapping("/updateCombo/{comboId}")
	public String updateCombo(@PathVariable long comboId,@RequestBody @Valid CafeComboDTO cafeComboDTO) {
		return iManagerService.updateCombo(comboId,cafeComboDTO);
	}
	
	@DeleteMapping("/deleteCombo/{comboId}")
	public String deleteCombo(@PathVariable long comboId) {
		return iManagerService.deleteCombo(comboId);
	}
	@GetMapping("/getAllCombo")	
	public List<CafeCombo>  getAllCombo(){
		return iManagerService.getAllCombo();
	}
	
	//Offer CRUD
	@PostMapping("/addOffer")
	public String addOffer(@RequestBody @Valid OfferDTO offerDTO) {
		return iManagerService.addOffer(offerDTO);
	}
	
	@PutMapping("/updateOffer/{offerCode}")
	public String updateOffer(@PathVariable String offerCode,@RequestBody @Valid OfferDTO offerDTO) {
		return iManagerService.updateOffer(offerCode,offerDTO);
	}
	
	@DeleteMapping("/deleteOffer/{offerCode}")
	public String deleteOffer(@PathVariable String offerCode) {
		return iManagerService.deleteOffer(offerCode);
	}
	@GetMapping("/getAllOffer")	
	public List<Offer>  getAllOffer(){
		return iManagerService.getAllOffer();
	}
}
