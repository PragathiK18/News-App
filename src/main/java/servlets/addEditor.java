package servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newsApp.dbManager;
import roles.editor;
import roles.manager;
import roles.user;

/**
 * Servlet implementation class addEditor
 */
@WebServlet("/myapp/addEditor")
public class addEditor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEditor() {
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
		UUID u=UUID.randomUUID();

		editor currentlyLogged=new editor(u.toString(),username,password,mailId,number);
	      user.usersMap.put(u.toString(),currentlyLogged);
		
		dbManager.addEditor(currentlyLogged);
		

		
	}

}
