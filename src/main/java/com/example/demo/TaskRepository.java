package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
	
	@Query(value = "select * from task ",nativeQuery = true)
	List<Task> findAll();
	
	@Query(value = "select * from task where id = :id ",nativeQuery = true)
	Task findById(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "update task set task_name = :taskName,description =:description where id = :id ",nativeQuery = true)  
	int update(@Param("id") int id,@Param("taskName") String taskName,@Param("description") String description);
	
	@Modifying
	@Transactional
	@Query(value = "update task set status = :status where id = :id ",nativeQuery = true)  
	int updateStatus(@Param("id") int id,@Param("status") String status);
	
	@Modifying
	@Transactional
	@Query(value = "delete from task where id = :id ",nativeQuery = true)  
	void delete(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "insert into  task (task_name, description, status) VALUES (:taskName,:description,:status) ",nativeQuery = true)  
	int insert(@Param("taskName") String taskName,@Param("description") String description,@Param("status") String status);

}



