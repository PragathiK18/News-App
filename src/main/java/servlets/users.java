package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roles.user;

/**
 * Servlet implementation class users
 */
@WebServlet("/users")
public class users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public users() {
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

		
		 
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String mailId=request.getParameter("mailid");
		String number=request.getParameter("number");
		String id=request.getParameter("id");
		
		System.out.println("username=" + mailId );

           UUID u=UUID.randomUUID();
	      Cookie cookie = new Cookie("user", u.toString());
	      response.addCookie(cookie);
	   user currentlyLogged= new user(u.toString(),username,password,mailId,number);
	      user.usersMap.put(u.toString(),currentlyLogged);
		user.users.add(new user(u.toString(),username,password,mailId,number));
		newsApp.dbManager.addUser(currentlyLogged);
	
		
		
	
	}

}
