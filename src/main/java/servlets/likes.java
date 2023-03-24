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

import newsApp.dbManager;

/**
 * Servlet implementation class likes
 */
@WebServlet("/myapp/likes")
public class likes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likes() {
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

		String id="";
		Cookie[] cookies = request.getCookies();
	      for (Cookie cookie : cookies) {
	         if (cookie.getName().equals("user")) {
	            id = cookie.getValue();
	            // ...
	         }
	      }
		int newsId=Integer.parseInt(request.getParameter("newsID"));
		int d=Integer.parseInt(request.getParameter("d"));
		
		
	     dbManager.addInLikes(id,newsId) ;
	
		String b=newsApp.dbManager.likes(newsId, d);
		
        response.getWriter().write(b);
		
		
		
		
		
		
		
		

		
	}

}
