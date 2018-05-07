package com.abhishek.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhishek.poc.entity.TodoEntity;

/**
 * 
 * @author Abhishek Bhardwaj
   @date Apr 2, 2018
 */
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

	@Query("select mL from todo mL " + "where mL.todoId like ?1%")
	public List<TodoEntity> findByTodoId(String todoId);

}
