package com.example.demo;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "task")
public class Task { 
	 @Id
	 @GeneratedValue
	 private Long id; 
	 @Column(name = "task_name") private String taskName; 
	 @Column(name = "description") private String description; 
	 @Column(name = "status") private String status;
    
	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", description=" + description + ", status=" + status
				+ "]";
	}

	
	
	public Task() {
		super();
		this.id = id;
		this.taskName = taskName;
		this.description = description;
		this.status = status;
	}



	 public Long getId() {
	        return id;
	    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
   
   
  
 
}
