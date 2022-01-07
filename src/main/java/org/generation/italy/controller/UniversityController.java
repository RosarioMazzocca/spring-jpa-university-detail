package org.generation.italy.controller;

import org.generation.italy.model.University;
import org.generation.italy.repository.DegreesRepository;
import org.generation.italy.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UniversityController {

	@Autowired
	private UniversityRepository repository;
	
	@GetMapping
	public String departments(Model model) {
		model.addAttribute("departments", repository.findAll(Sort.by("name")));
		return "departments";
	}
	
	@GetMapping("/department/{id}")
	public String degrees(Model model, @PathVariable Integer id) {
		
		University u = repository.getById(id);
		
		
		model.addAttribute("university", u);
		model.addAttribute("degrees", u.getDegrees());
		
		
		return "detail";
	}
	
}


