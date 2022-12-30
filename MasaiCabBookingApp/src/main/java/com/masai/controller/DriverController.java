package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.DriverException;
import com.masai.model.Driver;
import com.masai.service.DriverService;

@RequestMapping(value= "/masaicab", method= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class DriverController {
	
	@Autowired
	DriverService dservice;
	
	@PostMapping("/driver/register")
	public ResponseEntity<Driver> createDriverHandler(@Valid@RequestBody Driver driver)throws DriverException{
	Driver d= dservice.registerDriver(driver);
	return new ResponseEntity<Driver>(d,HttpStatus.CREATED);
	}
}
