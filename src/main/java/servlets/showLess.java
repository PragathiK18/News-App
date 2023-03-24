package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newsApp.dbManager;

/**
 * Servlet implementation class showLess
 */
@WebServlet("/myapp/showLess")
public class showLess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showLess() {
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
	         }
	      }	
		
		String newsId=request.getParameter("newsId");
	      dbManager.showLess(id,newsId);
	      System.out.print(id);
		
		
		
		
		
		
		
		
	}

}
