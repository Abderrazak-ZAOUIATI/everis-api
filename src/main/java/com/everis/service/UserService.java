package com.everis.service;

import com.everis.service.dto.UserDTO;

public interface UserService extends GenericService<UserDTO, Integer>{

	UserDTO getByEmailAndPassword(UserDTO userDto); 
}