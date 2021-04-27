package com.nagarro.dev.portal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dev.portal.models.City;
import com.nagarro.dev.portal.models.Country;
import com.nagarro.dev.portal.models.State;
import com.nagarro.dev.portal.repositories.CityRepository;
import com.nagarro.dev.portal.repositories.CountryRepository;
import com.nagarro.dev.portal.repositories.StateRepository;

@RestController
@CrossOrigin
@RequestMapping("/region")
public class RegionsController {
	
	@Autowired
	private CountryRepository country;
	
	@Autowired
	private StateRepository state;
	
	@Autowired
	private CityRepository city;
	
	@GetMapping("/getCountryList")
	public List<Country> getCountryList() {
		return country.findAll();
	}
	
	@GetMapping("/getStateList/{id}")
	public List<State> getStateList(@PathVariable("id") Integer id) {
		return state.findByCountryId(id);
	}
	
	@GetMapping("/getCityList/{id}")
	public List<City> getCityList(@PathVariable("id") Integer id) {
		return city.findByStateId(id);
	}

}
