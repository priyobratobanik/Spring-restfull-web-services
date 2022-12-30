package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.DriverRepo;
import com.masai.exception.DriverException;
import com.masai.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	DriverRepo drepo;
	
	@Override
	public Driver registerDriver(Driver driver) throws DriverException {
		
		if(driver!=null) {
		Driver d= drepo.save(driver);
		return d;
		}
		else
		throw new DriverException("Driver Cannot be registered");
	}

}
