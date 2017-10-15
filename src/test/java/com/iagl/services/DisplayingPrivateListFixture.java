package com.iagl.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.concordion.api.MultiValueResult;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.iagl.entities.TodoList;
import com.iagl.entities.User;
import com.iagl.errors.InvalidTodoListException;
import com.iagl.persistence.TodoListDAO;
import com.iagl.persistence.UserDAO;

@RunWith(ConcordionRunner.class)
public class DisplayingPrivateListFixture {
	
	protected TodoList todoList;
	
	protected User user;
	
	protected TodoListDAO todoListDAO;
	
	protected UserDAO userDAO;
	
	protected PrivateListService privateListService;
	
	@Before
	public void setUp() {
		//On mock les entités et DAOs
		this.user = mock(User.class);
		this.todoList = mock(TodoList.class);
		this.userDAO = mock(UserDAO.class);
		this.todoListDAO = mock(TodoListDAO.class);
		//On crée le service et on l'initialise avec les DAO
		this.privateListService = new PrivateListService();
		this.privateListService.setUserDAO(this.userDAO);
		this.privateListService.setTodoListDAO(this.todoListDAO);
	}
	
	public MultiValueResult searchList(String listName) {
		List<TodoList> lists = new ArrayList<TodoList>();
		lists.add(this.todoList);
		when(this.todoList.getName()).thenReturn(listName);
		when(this.user.getLists()).thenReturn(lists);
		TodoList list = this.privateListService.getListByUserAndName(this.user, listName);
		verify(this.user).getLists();
		verify(this.todoList).getName();
		return new MultiValueResult().with("list", list.getName());
	}
	
	public MultiValueResult searchListWithWrongName(String existingList, String searchedList) {
		List<TodoList> lists = new ArrayList<TodoList>();
		lists.add(this.todoList);
		when(this.todoList.getName()).thenReturn(existingList);
		when(this.user.getLists()).thenReturn(lists);
		TodoList list = this.privateListService.getListByUserAndName(this.user, searchedList);
		verify(this.user).getLists();
		verify(this.todoList).getName();
		if(list == null) {
			return new MultiValueResult().with("errorMessage", "There is no list with this name");
		}
		return null;
	}

}
