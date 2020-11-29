package com.BeckerNgo.web.jdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EditToDoServlet
 */
@WebServlet("/EditToDoServlet")
public class EditToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisterDBUtil registerDBUtil;
	
	@Resource(name="jdbc/WebToDoListDB")
	private DataSource dataSource;
	
	int id;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		registerDBUtil = new RegisterDBUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		id=Integer.parseInt(request.getParameter("todoId"));
		ToDo todo = registerDBUtil.fetchTodo(id);
		request.setAttribute("Todo", todo);
		request.getRequestDispatcher("/EditToDo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String descrip= request.getParameter("descripupdate");
		ToDo todo = new ToDo(id,descrip);
		registerDBUtil.updateTodo(todo);
		
		ArrayList<ToDo> todos;
		try {
			todos = registerDBUtil.getRegister();
			request.setAttribute("TODO_LIST", todos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/instructor-list-todo.jsp").forward(request, response);
	}
}
