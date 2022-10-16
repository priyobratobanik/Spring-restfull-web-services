package com.masai.ServiceLayer;

import java.time.LocalDate;
import java.util.List;

import com.masai.Exceptions.TaskException;
import com.masai.models.Task;

public interface TaskService {

    public Task createTasks(Task task)throws TaskException;
    
    public List<Task> findTaskByDate(LocalDate localDate)throws TaskException;
    
    public Task findByEmployeeId(Integer id)throws TaskException;
    
    public Task updateTask(Integer id)throws TaskException;
    
    public Task deleteTask(Integer id)throws TaskException;
}

