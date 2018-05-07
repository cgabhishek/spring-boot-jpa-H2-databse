package com.abhishek.poc.controller;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.poc.entity.TodoEntity;
import com.abhishek.poc.model.TodoRequest;
import com.abhishek.poc.service.TodoService;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 2, 2018
 */
@RestController
@RequestMapping(value = "todo", produces = "application/json")
public class ApplicationController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addTodo(@RequestHeader HttpHeaders headers, @RequestBody TodoRequest request)
			throws Exception {
		TodoEntity entity = new TodoEntity();
		entity.setStatus(request.getStatus());
		entity.setTodoId(request.getId());
		entity.setToDoJob(request.getTodoName());
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	todoService.addTodoListToDB(entity);;
		    }
		});
		thread.start();
		long endTimeMillis = System.currentTimeMillis() + 10000;
		while (thread.isAlive()) {
		    if (System.currentTimeMillis() > endTimeMillis) {
		        // set an error flag
		    	System.out.println("timeout");
		        break;
		    }
		    try {
		        Thread.sleep(500);
		    }
		    catch (InterruptedException t) {
		    	System.out.println("InterruptedException InterruptedException"+t);
		    }
		}
		System.out.println("result resultresultresult");
		//todoService.addTodoListToDB(entity);
		String response = "{\"response\":\"added successfully\"}";
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteTodo(@RequestHeader HttpHeaders headers, @RequestParam String todoId)
			throws Exception {
		todoService.deleteTodo(todoId);
		String response = "{\"response\":\"Deleted successfully\"}";
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> checkStatus(@RequestHeader HttpHeaders headers, @RequestParam String todoId)
			throws Exception {

		List<TodoEntity> listResponse = todoService.checkStatus(todoId);
		String status = null;
		if (null != listResponse && listResponse.size() > 0) {
			status = listResponse.get(0).getStatus();
		}
		String response = "{\"response\":\"" + status + "\"}";
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
