package com.everis.service;

import java.util.List;

import com.everis.service.dto.UserDTO;

public interface UserService extends GenericService<UserDTO, Integer>{

	UserDTO getByEmailAndPassword(UserDTO userDto);

	List<String> confirmAccount(int userId, String verificationCode);
}