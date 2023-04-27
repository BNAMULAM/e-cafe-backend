package com.example.cafe;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.cafe.dto.CafeComboDTO;
import com.example.cafe.dto.CafeItemsDTO;
import com.example.cafe.dto.ComboType;
import com.example.cafe.dto.ItemType;
import com.example.cafe.service.ManagerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ManagerTest {
	@Mock
	ManagerServiceImpl managerServiceImpl;
	
	@Test
	void AddItemTest() {
		CafeItemsDTO cafeItemsDTO = new CafeItemsDTO("DOSA","Masala","https://dosa.jpg",ItemType.SNACKS,50);
		when(managerServiceImpl.addItem(cafeItemsDTO)).thenReturn("Added");
		assertEquals(managerServiceImpl.addItem(cafeItemsDTO),"Added");
	
	}

	@Test
	void AddComboTest() {
		CafeComboDTO cafeComboDTO = new CafeComboDTO("DOSA","Masala","https://dosa.jpg",ComboType.SINGLE
				,50);
		when(managerServiceImpl.addCombo(cafeComboDTO)).thenReturn("Added");
		assertEquals(managerServiceImpl.addCombo(cafeComboDTO),"Added");
	
	}
	
}
