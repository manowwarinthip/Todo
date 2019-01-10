package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TodoController {
	
	@Autowired
	private Task task;
	
	 @Autowired
	 ITodoService todoService;
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public List<Task> getTask() {
		System.out.println("--- start getAllTask ---");
		List<Task> taskList = todoService.findAll();
		System.out.println(taskList);
		System.out.println("--- end getAllTask ---");
	   return taskList;
	 }

	
   @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
   public Task getTaskById(@PathVariable("id") String id) {
	   System.out.println("--- start getTaskById ---");
		Task task = todoService.findById(id);
		System.out.println(task);
		System.out.println("--- end getTaskById ---");
	   return task;
   }
   
   
	
	@RequestMapping(value="/task/update", method=RequestMethod.POST, consumes = "application/json")
	public String  updateTask(@RequestBody Task t) {		
		System.out.println("--- start updateTask ---");
		String respone = "";
		int task = todoService.update(t);
		System.out.println("--- end updateTask ---");
		if(task == 1){
			respone = "Update task success!!";
		}else{
			respone = "Update task fail!!";
		}
		return respone;
	}
	
	
	@RequestMapping(value="/task/add", method=RequestMethod.POST, consumes = "application/json")
	public String insertTask(@RequestBody Task t) {
		System.out.println("--- start insertTask ---");
		String respone = "";
		int task = todoService.insert(t);
		System.out.println("--- end insertTask ---");
		if(task == 1){
			respone = "Insert task success!!";
		}else{
			respone = "Insert task fail!!";
		}
		return respone;
	}
	
	
	
	@RequestMapping(value="/task/updatestatus", method=RequestMethod.POST, consumes = "application/json")
	public String updateTaskStatus(@RequestBody Task t) {
		System.out.println("--- start updateStatusTask ---");
		String respone = "";
		int task = todoService.updateStatus(t);
		System.out.println("--- end updateStatusTask ---");
		if(task == 1){
			respone = "Update task status success!!";
		}else{
			respone = "Update task status fail!!";
		}
		return respone;
	}

	 @RequestMapping(value = "/task/delete/{id}", method = RequestMethod.DELETE)
	 public void delete(@PathVariable("id") String id) {
		 System.out.println("--- start delete Task ---");
		 todoService.delete(id);
		 System.out.println("--- end delete Task ---");
	  }

}
