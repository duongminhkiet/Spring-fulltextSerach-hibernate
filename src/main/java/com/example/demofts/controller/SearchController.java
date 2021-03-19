package com.example.demofts.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demofts.objects.Employee;
import com.example.demofts.p2.EmployeeRepository;

@RestController
public class SearchController {

	@Autowired
	private EmployeeRepository repository;

	@PostMapping("/test")
	public List<Employee> search(@RequestParam(value = "search", required = false) String q) {
		List<Employee> searchResults = null;
		try {
			searchResults = repository.search(q);

		} catch (Exception ex) {
			// Nothing
		}
		//model.addAttribute("search", searchResults);
		return searchResults;// "index";

	}
	@PostMapping("/s2")
	public List<Employee> search2(@RequestParam(value = "search", required = false) String q) {
		List<Employee> searchResults = null;
		try {
			searchResults = repository.getPostBasedOnWord(q);

		} catch (Exception ex) {
			// Nothing
		}
		//model.addAttribute("search", searchResults);
		return searchResults;// "index";

	}
	@PostMapping("/s3")
	public List<Employee> search3(@RequestParam(value = "search", required = false) String q) {
		List<Employee> searchResults = null;
		try {
			searchResults = repository.getListyKey(q);

		} catch (Exception ex) {
			// Nothing
		}
		//model.addAttribute("search", searchResults);
		return searchResults;// "index";

	}

}