package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Cab;

public interface CabRepo extends JpaRepository<Cab, Integer> {

}
