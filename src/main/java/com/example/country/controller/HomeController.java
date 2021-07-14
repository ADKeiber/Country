package com.example.country.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.country.model.Country;
import com.example.country.service.CountryServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	CountryServiceImpl cService;

	@RequestMapping("/")
	public String home(Model model) {
		List<Country> countries = cService.getCountriesList();
		model.addAttribute("countries", countries);
		return "index";
	}
	
	
	@RequestMapping("/countryInfo/{countryId}")
	public ModelAndView countryInfo(@PathVariable(name = "countryId") int countryId) {
		ModelAndView mav = new ModelAndView("countryInfo");	
//		Country c = cService.getCountryById(countryId); 
//		c.setCountryId(countryId);
		System.out.println(countryId);
		mav.addObject("country", cService.getCountryById(countryId));
		return mav;
	}
	@RequestMapping("/editPopulation/{countryId}")
	public ModelAndView editPopulation(@PathVariable(name = "countryId") int countryId) {
		
		System.out.println(countryId);
		ModelAndView mav = new ModelAndView("editPopulation");	
		mav.addObject("country",cService.getCountryById(countryId));
		return mav;
		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST  )
	public String saveCountry(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
			return "newCountry";
		} else {
			cService.saveCountry(country);
			return "redirect:/";
		}

	}

	@PostMapping("/create")
	public String createCountry(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "newCountry";
		}
		cService.saveCountry(country);
		return "redirect:/";
	}

	@RequestMapping("/new")
	public String newCountry(Model model) {
		Country c = new Country();
		model.addAttribute("country",c);
		return "newCountry";
	}
	
	
	
}

