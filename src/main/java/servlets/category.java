package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.Category;
import roles.user;

/**
 * Servlet implementation class category
 */
@WebServlet("/myapp/category")
public class category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public category() {
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
		

		String a=request.getParameter("a");
		String arr = a.replace("[", "").replace("]", "");
		
//		System.out.println(Arrays.toString(arr));
		  String id="";
		Cookie[] cookies = request.getCookies();
	      for (Cookie cookie : cookies) {
	         if (cookie.getName().equals("user")) {
	            id = cookie.getValue();
	            // ...
	         }
	      }
	      
	//Category.categories.add(new Category(id,arr)); 
	      user.usersMap.get(id).categories.add(arr);
	      newsApp.dbManager.addCategory(id,arr); 
	      	      

}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


