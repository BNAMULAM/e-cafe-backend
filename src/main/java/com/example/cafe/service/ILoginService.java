package com.example.cafe.service;

import javax.validation.Valid;

import com.example.cafe.dto.LoginDTO;
import com.example.cafe.entity.Login;

public interface ILoginService {

	String register(@Valid LoginDTO loginDTO);

	Login login(String userName, String password);

}
