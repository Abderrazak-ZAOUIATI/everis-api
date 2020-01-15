package com.everis.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.service.UserService;
import com.everis.service.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserApi {	
	
	@Autowired 
	private UserService userService;
	
	@GetMapping()
	public List<UserDTO> getAll(){
		 
		return userService.getAll();
	} 
	
	@PostMapping()
	public UserDTO create(@RequestBody UserDTO userDTO){
		
		return userService.create(userDTO);
	}
	
	@PutMapping()
	public UserDTO update(@RequestBody UserDTO userDTO){
		
		return userService.update(userDTO);
	}
	
	@DeleteMapping("/{userId}")
	public List<String> delete(@PathVariable int userId){
		
		String result = userService.delete(userId);
		
		List<String> response = new ArrayList<String>();
		response.add(result);
		
		return response;
	}
	
	@GetMapping("/{userId}")
	public UserDTO getById(@PathVariable int userId){
		
		Optional<UserDTO> userDTOOptional = userService.getById(userId);

		return userDTOOptional.isPresent() ? userDTOOptional.get() : null;
	}
	 
	// User login	
	@PostMapping("/login")
	public UserDTO userLogin(@RequestBody UserDTO userDTO){

		return userService.getByEmailAndPassword(userDTO); 
	}

	// account verification	
	@PostMapping("/{userId}/account-verification")
	public List<String> accountVerification(@PathVariable int userId,@RequestBody String  verificationCode){

		return userService.confirmAccount(userId,verificationCode); 
	}

}
