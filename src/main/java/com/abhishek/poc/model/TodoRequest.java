package com.abhishek.poc.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @author Abhishek Bhardwaj
   @date Apr 2, 2018
 */
@JsonInclude
public class TodoRequest {

	protected String id;

	protected String status;

	protected String todoName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

}
