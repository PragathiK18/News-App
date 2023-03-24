package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newsApp.ApplicationVariables;
import newsApp.dbManager;
import roles.admin;
import roles.editor;
import roles.manager;
import roles.user;

/**
 * Servlet implementation class signIn
 */
@WebServlet("/signIn")
public class signIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String mailid=request.getParameter("mailid");	
		String password=request.getParameter("password");
		
		String sI =dbManager.signIn(mailid);
		
		String[] signInValues=sI.split("%");
		String password1=signInValues[0];
		String id=signInValues[1];
		
		
			if(password.equals(password1)) {
		
			      Cookie cookie = new Cookie("user", id);
			      response.addCookie(cookie);
			      System.out.println("fdgfgjh");
					
					response.getWriter().write("user");
					

					//
					try {
						dbManager.getdbConnection();
						PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("select * from users where mailId = ?");
						pt1.setString(1,mailid);
						ResultSet set=pt1.executeQuery();
						
						while(set.next()) {
							 id=set.getString(1);
							String username=set.getString(2);
							 password=set.getString(3);
							String mailId=set.getString(4);
							String number=set.getString(5);
							String comapnyId=set.getString(6);
							String role=set.getString(7);
							String status=set.getString(8);
							
							if(role.equals("user")) {
								user currentlyLogged= new user(id,username,password,mailId,number);
							      user.usersMap.put(id,currentlyLogged);
								  
							}else if(role.equals("manager")) {
								PreparedStatement pt2= ApplicationVariables.dbConnection.prepareStatement("select * from company where cId =? ");
								pt2.setString(1,comapnyId);
								
								ResultSet set2=pt2.executeQuery();
								if(set2.next()) {
									
									 String cId=set2.getString(1);
									 System.out.println(cId);
				                     String cName=set2.getString(2);
				                     String cAdress=set2.getString(3);
				                     String cNumber=set2.getString(4);
				                   
				                     user.usersMap.put(id, new manager( id,username, password, mailId, number,cName, cId,cAdress,cNumber,status));
				                     System.out.println("abc"+new manager( id,username, password, mailId, number,cName, cId,cAdress,cNumber,status).getcEmail());
								}
							
								
								
							}else if (role.equals("editor")) {
								
								editor currentlyLogged=new editor(id,username,password,mailId,number);
							      user.usersMap.put(id,currentlyLogged);
								
							}else if (role.equals("admin")){
								admin currentlyLogged=new admin(id,username,password,mailId,number);
							      user.usersMap.put(id,currentlyLogged);
							}
							
							
						}
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					}catch(Exception e) {
						
						e.getMessage();
						
						
					}
		
}else {
	
	Cookie cookie = new Cookie("user", null);
	response.addCookie(cookie);
	
}
		
		}	
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

