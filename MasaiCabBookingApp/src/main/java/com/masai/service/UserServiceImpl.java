package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.DriverRepo;
import com.masai.dao.UserRepo;
import com.masai.exception.DriverException;
import com.masai.exception.UserException;
import com.masai.model.Driver;
import com.masai.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo urepo;
	
	@Autowired
	DriverRepo drepo;
	
	
	@Override
	public User registerUser(User user) throws UserException {
		if(user!=null){
			User u=urepo.save(user);
			return u;
		}
		else
		throw new UserException("User Not Registered");
	}

	@Override
	public List<Driver> getDrivers() throws DriverException {
		List<Driver> list=drepo.findAll();
		if(list.size()==0) {
			throw new DriverException("No Driver available");
		}
		else {
			return list;
		}
	}

	@Override
	public Driver bookRide(Integer driverId, Integer x, Integer y) throws DriverException {
		Optional<Driver> opt= drepo.findById(driverId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else 
		 throw new DriverException("No Driver Available");
	}

}
