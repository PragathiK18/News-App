package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.commentData;
import newsApp.dbManager;

/**
 * Servlet implementation class addComment
 */
@WebServlet("/myapp/addComment")
public class addComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addComment() {
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

		String comm=request.getParameter("comments");
		String newsId=request.getParameter("newsId");
		DateFormat a=new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String id="";
		try {
		
			System.out.println("iiiddddddddddddd");
		
			Cookie[] cookies = request.getCookies();
		      for (Cookie cookie : cookies) {
		         if (cookie.getName().equals("user")) {
		            id = cookie.getValue();
		            // ...
		         }
		      }
		  
      
		}catch(Exception e) {
		    	  
		    	  
		    	System.out.print(e.getMessage());  
		    	dbManager.addComment(id,newsId,comm,a.format(date));
		      }
		String name=dbManager.nameOfUser(id);
		
		System.out.println("iiiddddddddddddd"+id);
		commentData.comm.add(new commentData(id,newsId,comm,date));
		System.out.println("neeewwwwwssssssiiiddddddddddddd"+newsId);
		dbManager.addComment(id,newsId,comm,a.format(date));

		response.getWriter().write(name);
		

		
		
	}

}
