package com.everis.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.service.ApplicationService;
import com.everis.service.dto.ApplicationDTO;

@RestController
@RequestMapping("/api/applications")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ApplicationApi {	
	
	
	@Autowired
	private ApplicationService applicationService;
	
	@GetMapping()
	public List<ApplicationDTO> getAll(){
		
		return applicationService.getAll();
	}
	
	@PostMapping()
	public ApplicationDTO create(@RequestBody ApplicationDTO applicationDTO){
		
		return applicationService.create(applicationDTO);
	}
	
	@PutMapping()
	public ApplicationDTO update(@RequestBody ApplicationDTO applicationDTO){
		
		return applicationService.update(applicationDTO);
	}
	
	@DeleteMapping("/{applicationId}")
	public List<String> delete(@PathVariable int applicationId){
		
		String result = applicationService.delete(applicationId);
		
		List<String> response = new ArrayList<String>();
		response.add(result);
		
		return response;
	}
	
	@GetMapping("/{applicationId}")
	public ApplicationDTO getById(@PathVariable int applicationId){
		
		Optional<ApplicationDTO> applicationDTOOptional = applicationService.getById(applicationId);

		return applicationDTOOptional.isPresent() ? applicationDTOOptional.get() : null;
	}
}
