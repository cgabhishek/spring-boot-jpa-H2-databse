package com.abhishek.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhishek.poc.entity.TodoEntity;
import com.abhishek.poc.repository.TodoRepository;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 2, 2018
 */
@Component
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	public void addTodoListToDB(TodoEntity entity) {
		todoRepository.save(entity);

	}

	public void deleteTodo(String todoId) {
		todoRepository.delete(todoId);

	}

	public List<TodoEntity> checkStatus(String todoId) {
		return todoRepository.findByTodoId(todoId);

	}

}
