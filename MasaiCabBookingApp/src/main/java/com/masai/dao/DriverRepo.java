package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Driver;

public interface DriverRepo extends JpaRepository<Driver, Integer> {

}
