package com.masai.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.EmployeeException;
import com.masai.Exceptions.TaskException;
import com.masai.ServiceLayer.EmployeeService;
import com.masai.ServiceLayer.TaskService;
import com.masai.models.Employee;
import com.masai.models.Task;

@RestController
public class TaskController {
	@Autowired
	private TaskService tService;
	
//	@Autowired
//	private EmployeeService eService;
	

	@PostMapping("/task")
	public ResponseEntity<Task> saveTask(@Valid @RequestBody Task task) throws TaskException {

		Task savedTask = tService.createTasks(task);
		return new ResponseEntity<Task>(savedTask, HttpStatus.CREATED);
	}
	
	
//	@GetMapping("/task/{localdate}")
//	public ResponseEntity<List<Task>> getTaskByDate(@RequestBody Task task ,@PathVariable ("localdate")LocalDate ld)throws TaskException{
//		
//		List<Task> tasks=tService.findTaskByDate(ld);
//		return new ResponseEntity<List<Task>>(tasks, HttpStatus.CREATED);
//	}
//	
	
	

}
