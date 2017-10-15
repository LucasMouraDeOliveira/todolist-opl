package com.iagl.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.concordion.api.MultiValueResult;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.iagl.entities.TodoList;
import com.iagl.entities.User;
import com.iagl.errors.TodoListAlreadyExistException;
import com.iagl.persistence.TodoListDAO;
import com.iagl.persistence.UserDAO;
import com.iagl.services.PrivateListService;

@RunWith(ConcordionRunner.class)
public class CreatingPrivateListFixture {
	
	protected TodoListDAO todoListDAO;
	
	protected UserDAO userDAO;
	
	protected TodoList todoList;
	
	protected User user;
	
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

	public MultiValueResult createNewListWithNoExistingLists(String listName) throws TodoListAlreadyExistException {
		List<TodoList> lists = new ArrayList<TodoList>();
		//On définit le comportement attendu pour les mocks
		when(this.todoList.getName()).thenReturn(listName);
		when(this.user.getLists()).thenReturn(lists);
		//On vérifie le comportement du service
		this.privateListService.addListToUser(this.todoList, this.user);
		verify(this.user).getLists();
		//verify(this.user).addList(this.todoList);
		verify(this.todoListDAO).insert(this.todoList);
		verify(this.userDAO).update(this.user);
		//On retourne le nom de la liste ajoutée à Concordion
		lists.add(todoList);
		List<TodoList> userLists = this.user.getLists();
		return new MultiValueResult().with("list", userLists.get(0).getName());
	}
	
	public MultiValueResult createNewListWithExistingList(String existingList, String newList) throws TodoListAlreadyExistException {
		List<TodoList> lists = new ArrayList<TodoList>();
		TodoList existingTodoList = mock(TodoList.class);
		lists.add(existingTodoList);
		//On d�finit le comportement attendu pour les mocks
		when(this.todoList.getName()).thenReturn(newList);
		when(existingTodoList.getName()).thenReturn(existingList);
		when(this.user.getLists()).thenReturn(lists);
		//On v�rifie le comportement du service
		this.privateListService.addListToUser(this.todoList, this.user);
		verify(this.user).getLists();
		verify(this.todoList).getName();
		verify(existingTodoList).getName();
		//verify(this.user).addList(this.todoList);
		verify(this.todoListDAO).insert(this.todoList);
		verify(this.userDAO).update(this.user);
		//On retourne le nom des listes � Concordion
		List<TodoList> userLists = this.user.getLists();
		return new MultiValueResult()
				.with("list1", userLists.get(0).getName())
				.with("list2", userLists.get(1).getName())
				.with("length", userLists.size());
	}
	
	public MultiValueResult createNewListWithExistingListWithSameName(String listName) {
		List<TodoList> lists = new ArrayList<TodoList>();
		TodoList existingTodoList = mock(TodoList.class);
		lists.add(existingTodoList);
		//On d�finit le comportement attendu pour les mocks
		when(this.todoList.getName()).thenReturn(listName);
		when(existingTodoList.getName()).thenReturn(listName);
		when(this.user.getLists()).thenReturn(lists);
		//On v�rifie le comportement du service
		try {
			this.privateListService.addListToUser(this.todoList, this.user);
		} catch (TodoListAlreadyExistException e) {
			return new MultiValueResult().with("errorMessage", "There is already a list with this name");
		}
		return null;
	}
	
}
