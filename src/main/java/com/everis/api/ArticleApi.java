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

import com.everis.service.ArticleService;
import com.everis.service.dto.ArticleDTO;

@RestController
@RequestMapping("/api/articles")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ArticleApi {	
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping()
	public List<ArticleDTO> getAll(){
		
		return articleService.getAll();
	}
	
	@PostMapping()
	public ArticleDTO create(@RequestBody ArticleDTO userDTO){
		
		return articleService.create(userDTO);
	}
	
	@PutMapping()
	public ArticleDTO update(@RequestBody ArticleDTO articleDTO){
		
		return articleService.update(articleDTO);
	}
	
	@DeleteMapping("/{articleId}")
	public List<String> delete(@PathVariable int articleId){
		
		String result = articleService.delete(articleId);
		
		List<String> response = new ArrayList<String>();
		response.add(result);
		
		return response;
	}
	
	@GetMapping("/{articleId}")
	public ArticleDTO getById(@PathVariable int articleId){
		
		Optional<ArticleDTO> articleDTOOptional = articleService.getById(articleId);

		return articleDTOOptional.isPresent() ? articleDTOOptional.get() : null;
	}
}
