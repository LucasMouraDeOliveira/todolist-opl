package com.iagl.services;

import java.util.List;

import org.concordion.api.MultiValueResult;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import com.iagl.entities.TodoList;
import com.iagl.entities.User;
import com.iagl.errors.TodoListAlreadyExistException;

@RunWith(ConcordionRunner.class)
public class CreatingPrivateListFixture {

	public MultiValueResult createNewListWithNoExistingLists(String listName) throws TodoListAlreadyExistException {
		User user = new User();
		TodoList todoList = new TodoList(listName);
		user.addList(todoList);
		List<TodoList> userLists = user.getLists();
		return new MultiValueResult().with("list", userLists.get(0).getName());
	}
	
	public MultiValueResult createNewListWithExistingList(String existingList, String newList) throws TodoListAlreadyExistException {
		User user = new User();
		TodoList existingTodoList = new TodoList(existingList);
		user.addList(existingTodoList);
		TodoList newTodoList = new TodoList(newList);
		user.addList(newTodoList);
		List<TodoList> userLists = user.getLists();
		return new MultiValueResult()
				.with("list1", userLists.get(0).getName())
				.with("list2", userLists.get(1).getName())
				.with("length", userLists.size());
	}
	
	public MultiValueResult createNewListWithExistingListWithSameName(String listName) {
		User user = new User();
		//On ajoute la première liste
		TodoList existingTodoList = new TodoList(listName);
		try {
			user.addList(existingTodoList);
		} catch (TodoListAlreadyExistException e1) {
			return null;
		}
		//On ajoute une liste avec le même nom que la première
		TodoList newTodoList = new TodoList(listName);
		try {
			user.addList(newTodoList);
		} catch(TodoListAlreadyExistException e) {
			return new MultiValueResult().with("errorMessage", "There is already a list with this name");
		}
		return null;
	}
	
}
