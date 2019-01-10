package com.example.demo;

import java.util.List;

public interface ITodoService {
	public List<Task> findAll();
	public Task findById(String id);
	public int update(Task t);
	public int updateStatus(Task t);
	public void delete(String id);
	public int insert(Task t);
}
