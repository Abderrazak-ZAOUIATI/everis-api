package com.everis.api;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.everis.service.ArticleService;
import com.everis.service.dto.ArticleDTO;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ArticleApi {

	@Autowired
	private ArticleService articleService;

	@GetMapping()
	public List<ArticleDTO> getAll() {

		return articleService.getAll();
	}

	@PostMapping()
	public ArticleDTO create(@RequestBody ArticleDTO articleDTO) {

		return articleService.create(articleDTO);
	}

	@PutMapping()
	public ArticleDTO update(@RequestBody ArticleDTO articleDTO) {

		return articleService.update(articleDTO);
	}

	@DeleteMapping("/{articleId}")
	public List<String> delete(@PathVariable int articleId) {

		String result = articleService.delete(articleId);

		List<String> response = new ArrayList<String>();
		response.add(result);

		return response;
	}

	@GetMapping("/{articleId}")
	public ArticleDTO getById(@PathVariable int articleId) {

		Optional<ArticleDTO> articleDTOOptional = articleService.getById(articleId);

		return articleDTOOptional.isPresent() ? articleDTOOptional.get() : null;
	}

	@PostMapping("/upload-image")
	public ArticleDTO handleFileUpload(@RequestParam("image") MultipartFile image,
			@RequestParam("title") String title, @RequestParam("content") String content) {

		String filename = StringUtils.cleanPath(image.getOriginalFilename());
		File newFile = new File("src/main/resources/static/articles/images/" + filename);
		String extension = filename.substring(filename.lastIndexOf("."), filename.length());
		
		ArticleDTO articleDTO = null;
		
		if( extension.equals(".png") || extension.equals(".PNG") || extension.equals(".jpg") ) {
		 	
			try {
				
				newFile.createNewFile();
				FileOutputStream dist = new FileOutputStream(newFile);
				dist.write(image.getBytes());
				dist.close();
				
				articleDTO = new ArticleDTO(0, title, content, filename, LocalDate.now().toString(), "Active", null);
				articleDTO = articleService.create(articleDTO);
			} catch (Exception e) {
				
				System.out.println("An error during upload the file");
			}

		}
		
		return articleDTO;
	}
	@PostMapping("/{articleId}/status")
	public ArticleDTO changeArticleStatus(@PathVariable String articleId) {

		return articleService.changeArticleStatus(Integer.parseInt(articleId));
	}
}
