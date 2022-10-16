package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.models.Task;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer> {
	@Query("select * from Task where startdate =?")
	public List<Task> findByStartdate(LocalDate ld); 
		
	
}
