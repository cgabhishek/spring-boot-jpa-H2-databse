package com.abhishek.poc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 
 * @author Abhishek Bhardwaj
   @date Apr 2, 2018
 */
@Entity(name = "todo")
public class TodoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String todoId;

	@Column
	private String status;

	@Column
	private String toDoJob;

	public TodoEntity(String todoId, String status, String toDoJob) {
		super();
		this.todoId = todoId;
		this.status = status;
		this.toDoJob = toDoJob;
	}

	public TodoEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getTodoId() {
		return todoId;
	}

	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToDoJob() {
		return toDoJob;
	}

	public void setToDoJob(String toDoJob) {
		this.toDoJob = toDoJob;
	}

}
