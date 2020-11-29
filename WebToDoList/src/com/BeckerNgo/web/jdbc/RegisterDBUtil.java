package com.BeckerNgo.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.sql.DataSource;

public class RegisterDBUtil {
	
	private DataSource dataSource;
	
	public RegisterDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try{
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
			if(myConn!=null)
				myConn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

	
	public int login (String id,String mdp) {
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		int status=-1;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select status from register where identifiant=\"" + id + "\" and password=\""+mdp+ "\"";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				status = myRs.getInt("status");
			}			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		} finally{
			close(myConn,myStmt,myRs);
		}
		return status;
	}
	
	
	public String recover() {

		Connection myConn=null;
		Statement myStmt= null;
		ResultSet myRs=null;
		String descrip="";

		try{
			myConn= dataSource.getConnection();
			//Step3: create SQL statements
			String sql = "select * from todo";
			myStmt= myConn.createStatement();
			//Step4: Execute SQL query
			myRs=myStmt.executeQuery(sql);
			//Step5: Process the ResultSet
			while(myRs.next()){
				descrip = descrip + "<br>"+ myRs.getString("descrip");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		} finally{
			close(myConn,myStmt,myRs);
		}
		return descrip;

	}
	
	public ArrayList<ToDo> getRegister() throws Exception {
		ArrayList<ToDo> todo= new ArrayList<ToDo>();
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todo order by id";
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				int id = myRs.getInt("id");
				String descrip=myRs.getString("descrip");
				ToDo tempTodo= new ToDo(id,descrip);
				todo.add(tempTodo);
			}
		} finally{
			close(myConn,myStmt,myRs);
		}
		return todo;
	}
	
	public void add (String descrip ){
		//We can use also PreparedStatement !!
		//-> 		myStmt.setString(1, descrip);
		Connection myConn=null;
		Statement myStmt = null;	
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql = "INSERT INTO todo (descrip) VALUES (\'"+ descrip +"\')";	

			myStmt.execute(sql);
		}
		catch(Exception exc){
			System.out.println(exc.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}
	
	public ToDo fetchTodo(int id) {
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		ToDo todo=null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select * from todo where id="+id;
			myRs = myStmt.executeQuery(sql);
			while(myRs.next()){
				String descrip=myRs.getString("descrip");
				todo = new ToDo(id,descrip);
			}
			return todo;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		} finally{
			close(myConn,myStmt,myRs);
		}
	}
	
	public void deleteTodo(int id) {
		// TODO Auto-generated method stub
		Connection myConn=null;
		Statement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "delete from todo where id="+id;
			myStmt.execute(sql);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{ close(myConn,myStmt,null); }
	}
	
	public void updateTodo(ToDo todo) {
		Connection myConn=null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "update todo set descrip=? where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1,todo.getDescrip());
			myStmt.setInt(2,todo.getId());
			myStmt.execute();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			close(myConn,myStmt,null);
		}
	}

	
}
