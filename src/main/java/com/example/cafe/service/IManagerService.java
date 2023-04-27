package com.example.cafe.service;

import java.util.List;

import javax.validation.Valid;

import com.example.cafe.dto.CafeComboDTO;
import com.example.cafe.dto.CafeItemsDTO;
import com.example.cafe.dto.LoginDTO;
import com.example.cafe.dto.OfferDTO;
import com.example.cafe.entity.CafeCombo;
import com.example.cafe.entity.CafeItems;
import com.example.cafe.entity.Offer;
import com.example.cafe.exception.AlreadyExistsException;
import com.example.cafe.exception.DoesnotExistsException;

public interface IManagerService {

	String addItem(@Valid CafeItemsDTO cafeItemsDTO) throws AlreadyExistsException;

	String updateItem(long itemId, @Valid CafeItemsDTO cafeItemsDTO) throws DoesnotExistsException;

	String deleteItem(long itemId) throws DoesnotExistsException;

	List<CafeItems> getAllItems();

	String addCombo(@Valid CafeComboDTO cafeComboDTO)throws AlreadyExistsException;;

	String updateCombo(long comboId, @Valid CafeComboDTO cafeComboDTO) throws DoesnotExistsException;

	String deleteCombo(long comboId) throws DoesnotExistsException;

	List<CafeCombo> getAllCombo();

	String addOffer(@Valid OfferDTO offerDTO)throws AlreadyExistsException;;

	String updateOffer(String offerCode, @Valid OfferDTO offerDTO) throws DoesnotExistsException;

	String deleteOffer(String offerCode) throws DoesnotExistsException;

	List<Offer> getAllOffer();

	String registerManager(@Valid LoginDTO loginDTO);

	String loginManager(String userName, String password);

}
