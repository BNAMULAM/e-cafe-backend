package com.example.cafe.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.dto.LoginDTO;
import com.example.cafe.entity.Login;
import com.example.cafe.exception.AlreadyExistsException;
import com.example.cafe.exception.InvalidException;
import com.example.cafe.repository.LoginRepo;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginRepo loginRepo;
	
	@Override
	public String register(@Valid LoginDTO loginDTO) {
		if(loginRepo.findById(loginDTO.getUserName()).isEmpty()) {
			Login login = new Login(
					loginDTO.getUserName(),
					loginDTO.getPassword(),
					loginDTO.getRole().toString(),
					loginDTO.getMobileNumber());
			loginRepo.save(login);
			return "Registered";
		}
		else {
			throw new AlreadyExistsException("User with Similar username already exists");
		}
	}

	@Override
	public Login login(String userName, String password) {
		// TODO Auto-generated method stub
		Optional<Login> loginObj = loginRepo.findById(userName);
		if(loginObj.isPresent() && loginObj.get().getPassword().equals(password)) {
			return loginObj.get();
		}
		throw new InvalidException("Login details not found");
	}

}
