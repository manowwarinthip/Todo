package com.example.demo;

import java.util.List;
import java.util.Optional;

import com.example.demo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public  class TodoService implements ITodoService{
	 @Autowired
	  private TaskRepository repository;
	 
	
	 @Override
	    public List<Task> findAll() {
	        List<Task> taskList = (List<Task>) repository.findAll();
	        return taskList;
	    }
	 
	
	 @Override
	    public Task findById(String idStr) {		 
		 	int id = Integer.parseInt(idStr);
	        Task task = (Task) repository.findById(id);	        
	        return task;
	    }
	 
	 @Override
	    public int update(Task t) {		
		 	int result = 0;
		 	int id = t.getId().intValue();
		 	Task task = repository.findById(id);
		 	if(!task.equals("") && task != null ){
		 		String taskName = t.getTaskName();
		 		String description = t.getDescription();		 		
		        result =  repository.update(id,taskName,description);	
		 	}		 	        
	        return result;
	    }
	 
	 @Override
	    public int updateStatus(Task t) {		
		 	int result = 0;
		 	int id = t.getId().intValue();
		 	Task task = repository.findById(id);
		 	if(!task.equals("") && task != null ){
		 		String status = t.getStatus();	
		 		if((status.equals("done")) || (status.equals("pending"))){
		 			 result =  repository.updateStatus(id,status);
		 		}		       	
		 	}		 	        
	        return result;
	    }
	 
	 @Override
	    public void delete(String idStr) {		
			int id = Integer.parseInt(idStr);
	        repository.delete(id);	        	        
	    }
	 
	 @Override
	    public int insert(Task t) {		
		 	int result = 0;
		 		String taskName = t.getTaskName();
		 		String description = t.getDescription();		
		 		String status = t.getStatus();
		 		if((status.equals("done")) || (status.equals("pending"))){
		 			  result =  repository.insert(taskName,description,status);
		 		}			      		 	        
	        return result;
	    }
	
}
