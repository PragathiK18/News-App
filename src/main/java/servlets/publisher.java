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

import newsApp.ApplicationVariables;
import roles.manager;
import roles.user;


/**
 * Servlet implementation class publisher
 */
@WebServlet("/publisher")
public class publisher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public publisher() {
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

		 UUID u=UUID.randomUUID();
	      Cookie cookie = new Cookie("user", u.toString());
	      response.addCookie(cookie);

     
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String mailId=request.getParameter("mailid");
	String number=request.getParameter("number");
    String cName=request.getParameter("cName");
	String cEmail  =request.getParameter("email");
	String cAdress=request.getParameter("adress");
	String cNumber=request.getParameter("cNumber");
	
	System.out.println("username=" + mailId );
	
	user.usersMap.put(u.toString(), new manager( u.toString(),username, password, mailId, number,cName, cEmail,cAdress,cNumber,"waitingList"));
	user.users.add(new manager( u.toString(),username, password, mailId, number,cName, cEmail,cAdress,cNumber,"waitingList"));
	newsApp.dbManager.addManager(u.toString(), username, password, mailId, cNumber, cEmail);
	newsApp.dbManager.addCompany(cEmail, cName, cAdress, cNumber);
	

	

		
		
	}

}
