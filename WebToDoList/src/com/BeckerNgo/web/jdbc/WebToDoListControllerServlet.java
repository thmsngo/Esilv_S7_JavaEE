package com.BeckerNgo.web.jdbc;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class WebToDoListControllerServlet
 */
@WebServlet("/WebToDoListControllerServlet")
public class WebToDoListControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisterDBUtil registerDBUtil;
	
	@Resource(name="jdbc/WebToDoListDB")
	private DataSource dataSource;

	
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
		try {
			
			Cookie [] cookies = request.getCookies();
			if(cookies!= null) {
				for(Cookie cookie:cookies) {
					if(cookie.getName().equals("prenom")) {
						request.setAttribute("prenom", cookie.getValue());
					}
				}
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id= request.getParameter("username");
		String password= request.getParameter("password");

		//Test to recover username and password

		request.setAttribute("username", id);
		request.setAttribute("password",password);	

		int status = registerDBUtil.login(id,password);
		String status2 = Integer.toString(status);
		request.setAttribute("status",status2);	
		
		String descrip = registerDBUtil.recover();
		request.setAttribute("descrip", descrip);

		
		Cookie cookie = new Cookie("prenom", id);
		cookie.setMaxAge(60*60*24) ;
		response.addCookie(cookie) ;
		
		ArrayList<ToDo> todos;
		try {
			todos = registerDBUtil.getRegister();
			request.setAttribute("TODO_LIST", todos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(status == 1) {
			//instructor
			request.getRequestDispatcher("/instructor-list-todo.jsp").forward(request, response);
		}
		else if(status == 0) {
			//student
			request.getRequestDispatcher("/student-list-todo.jsp").forward(request, response);
		}
		else {
			//not autorized
			request.getRequestDispatcher("/loginfailed.jsp").forward(request, response);
		}
	}

}
