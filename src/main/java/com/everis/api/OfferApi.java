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
import com.everis.service.OfferService;
import com.everis.service.dto.OfferDTO;

@RestController
@RequestMapping("/api/offers")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OfferApi {	
	
	@Autowired
	private OfferService offerService;
	
	@GetMapping()
	public List<OfferDTO> getAll(){
		
		return offerService.getAll();
	}
	
	@PostMapping()
	public OfferDTO create(@RequestBody OfferDTO offerDTO){
		
		return offerService.create(offerDTO);
	}
	
	@PutMapping()
	public OfferDTO update(@RequestBody OfferDTO offerDTO){
		
		return offerService.update(offerDTO);
	}
	
	@DeleteMapping("/{offerId}")
	public List<String> delete(@PathVariable int offerId){
		
		String result = offerService.delete(offerId);
		
		List<String> response = new ArrayList<String>();
		response.add(result);
		
		return response;
	}
	
	@GetMapping("/{offerId}")
	public OfferDTO getById(@PathVariable int offerId){
		
		Optional<OfferDTO> offerDTOOptional = offerService.getById(offerId);

		return offerDTOOptional.isPresent() ? offerDTOOptional.get() : null;
	}
}
