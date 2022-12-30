package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverException;
import com.masai.exception.UserException;
import com.masai.model.Driver;
import com.masai.model.User;
import com.masai.service.UserService;

@RequestMapping(value= "/masaicab/user", method= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
public class UserController {
	
	@Autowired
	UserService uservice;

	
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUserHandler(@Valid@RequestBody User user)throws UserException{
		User u= uservice.registerUser(user);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/findride")
	public ResponseEntity<List<Driver>> getAllDriversHandler()throws DriverException{
		List<Driver> list= uservice.getDrivers();
		return new ResponseEntity<List<Driver>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/user/book/{driverid}/{x}/{y}")
	public ResponseEntity<Driver> bookRideHandler(@Valid@PathVariable Integer driverid, Integer x, Integer y)throws DriverException{
		Driver d= uservice.bookRide(driverid, x, y);
		return new ResponseEntity<Driver>(d,HttpStatus.OK);
	}
}
