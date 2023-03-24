package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import news.newsData;

/**
 * Servlet implementation class news
 */
@WebServlet("/myapp/news")
public class news extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public news() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id="";
			Cookie[] cookies = request.getCookies();
		      for (Cookie cookie : cookies) {
		         if (cookie.getName().equals("user")) {
		            id = cookie.getValue();
		            // ...
		         }
		      }
		     
		    	  System.out.println("iiiiiiiiiiiiiiidddddddddddd"+id);     		      
		 		 JSONArray a =newsApp.dbManager.showNews(id);
		 		 JSONParser parser = new JSONParser();
		 		 System.out.println(a);
		 		 //JSONObject news=parser.parse(a);
//		 		 for(JSONObject json : a) {
////		 			 JSONObject c =  parser.parse(a.get(i).);
//		 			 newsData.News.add(new news(json.get("id"))); 
//		 			 
//		 		 }
		 		 
//		 		 for(int i=0;i<a.size();i++) {
//		 		
//		 			int id1 = (int)((JSONObject)a.get(i)).get("id");
//		 			String logo = (String)((JSONObject)a.get(i)).get("logo");
//		 			String cName = (String)((JSONObject)a.get(i)).get("companyName");
//		 			String newsTitle = (String)((JSONObject)a.get(i)).get("newsTitle");
//		 			String newsImg= (String)((JSONObject)a.get(i)).get("newsImg");
//		 			String newsContent = (String)((JSONObject)a.get(i)).get("newsContent");
//		 			String category = (String)((JSONObject)a.get(i)).get("category");
//		 			String likes = (String)((JSONObject)a.get(i)).get("likes");
//		 			int l=Integer.parseInt(likes);
//		 			String date = (String)((JSONObject)a.get(i)).get("date");
//		 			
//		 			newsData.News.add(new newsData(id1,logo,cName,newsTitle,newsImg,newsContent,category,l,date));
//		 		 }
		 				response.getWriter().append(a.toString());

		      }
		
		


		
		 catch (Exception e) {
			// TODO Auto-generated catch block
System.out.print(e.getMessage());
				
		}
		
		

		
		
		
		
		
		
		
		
		
	}

}
