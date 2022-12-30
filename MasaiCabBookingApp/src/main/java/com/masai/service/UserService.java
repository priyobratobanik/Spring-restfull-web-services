package com.masai.service;

import java.util.List;

import com.masai.exception.DriverException;
import com.masai.exception.UserException;
import com.masai.model.Driver;
import com.masai.model.User;

public interface UserService {
		
	public User registerUser(User user)throws UserException;
	public List<Driver> getDrivers()throws DriverException;
	public Driver bookRide(Integer driverId,Integer x, Integer y)throws DriverException;
}
