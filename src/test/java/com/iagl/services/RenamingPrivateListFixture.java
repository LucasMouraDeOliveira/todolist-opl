//package com.iagl.services;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.concordion.api.MultiValueResult;
//import org.concordion.integration.junit4.ConcordionRunner;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//
//import com.iagl.entities.TodoList;
//import com.iagl.entities.User;
//import com.iagl.errors.TodoListAlreadyExistException;
//import com.iagl.persistence.TodoListDAO;
//import com.iagl.persistence.UserDAO;
//import com.iagl.services.PrivateListService;
//
//@RunWith(ConcordionRunner.class)
//public class RenamingPrivateListFixture {
//	
//	protected TodoList todoList;
//	
//	protected User user;
//	
//	protected TodoListDAO todoListDAO;
//	
//	protected UserDAO userDAO;
//	
//	protected PrivateListService privateListService;
//	
//	@Before
//	public void setUp() {
//		//Initializing mocks here
//		this.todoList = mock(TodoList.class);
//		this.user = mock(User.class);
//		this.todoListDAO = mock(TodoListDAO.class);
//		this.userDAO = mock(UserDAO.class);
//		//Intializing service
//		this.privateListService = new PrivateListService();
//		this.privateListService.setTodoListDAO(this.todoListDAO);
//		this.privateListService.setUserDAO(this.userDAO);
//	}
//	
//	public MultiValueResult renameList(String currentName, String newName) throws TodoListAlreadyExistException {
//		List<TodoList> lists = new ArrayList<TodoList>();
//		lists.add(this.todoList);
//		//Arrange
//		when(this.todoList.getName()).thenReturn(currentName);
//		when(this.user.getLists()).thenReturn(lists);
//		//Act
//		this.privateListService.renameListForUser(this.user, this.todoList, newName);
//		//Assert
//		verify(this.user).getLists();
//		verify(this.todoList).setName(newName);
//		verify(this.todoListDAO).update(this.todoList);
//		//Concordion
//		
//		// C'est pas terrible de faire �a je crois mais j'ai pas le choix
//		when(this.todoList.getName()).thenReturn(newName);
//		return new MultiValueResult().with("newListName", this.todoList.getName());
//		
//		//Sinon c'est : 
//		// return new MultiValueResult().with("newListName", newName);
//	}
//	
//	public MultiValueResult renameListWithSameName(String nomListe, String nomDoublon) {
//		TodoList liste2 = mock(TodoList.class);
//		List<TodoList> lists = new ArrayList<TodoList>();
//		lists.add(this.todoList);
//		lists.add(liste2);
//		//Arrange
//		when(this.todoList.getName()).thenReturn(nomListe);
//		when(liste2.getName()).thenReturn(nomDoublon);
//		when(this.user.getLists()).thenReturn(lists);
//		//Act
//		try {
//			this.privateListService.renameListForUser(this.user, this.todoList, nomDoublon);
//		} catch (TodoListAlreadyExistException e) {
//			//Concordion
//			return new MultiValueResult().with("errorMessage", "There is already a list with this name");
//		}
//		return null;
//	}
//
//}
