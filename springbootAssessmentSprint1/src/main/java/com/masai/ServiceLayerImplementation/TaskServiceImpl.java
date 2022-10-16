package com.masai.ServiceLayerImplementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.TaskException;
import com.masai.Repository.TaskDao;
import com.masai.ServiceLayer.TaskService;
import com.masai.models.Task;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao tDao;

	@Override
	public Task createTasks(Task task) throws TaskException{
		if(task!=null) {
			Task existingTask=tDao.save(task);	
		}
		else {
			throw new TaskException("No task saved");
		}
		
		
		return null;
	}

	@Override
	public List<Task> findTaskByDate(LocalDate localDate) throws TaskException {
		List<Task> tasks=tDao.findByStartdate(localDate);
		return tasks;
	}

	@Override
	public Task updateTask(Integer id) throws TaskException {
		
		Task task=tDao.findById(id).orElseThrow(() -> new TaskException("task not found by id"));
		 tDao.save(task);
		 return task;	}

	@Override
	public Task deleteTask(Integer id) throws TaskException {
		Task task=tDao.findById(id).orElseThrow(() -> new TaskException("task not found by id"));
		 tDao.delete(task);
		 return task;
	}

	@Override
	public Task findByEmployeeId(Integer id) throws TaskException {
		return tDao.findById(id).orElseThrow(() ->  new TaskException("task not found by id"));
	}

}

