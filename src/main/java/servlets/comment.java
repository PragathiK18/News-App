package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import news.commentData;
import newsApp.dbManager;


/**
 * Servlet implementation class comment
 */
@WebServlet("/myapp/comment")
public class comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String comm = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment() {
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
	
		
		
		
String newsId=request.getParameter("newsID");
//		
String id="";
		try {
			
			Cookie[] cookies = request.getCookies();
		      for (Cookie cookie : cookies) {
		         if (cookie.getName().equals("user")) {
		            id = cookie.getValue();
		            // ...
		         }
		      }
		}catch(Exception e) {
			e.getMessage();
		}
//		     	
//		
//		String arr=newsApp.dbManager.comment(newsId);
//		System.out.println("start : "+arr);
//		JSONParser j = new JSONParser();
//		JSONArray o;
//		try {
//			o = (JSONArray) j.parse(arr);
//			commentData.comm.removeAll(commentData.comm);
//			for(int i=0; i<o.size();i++) {
//				String d=(String)((JSONObject)o.get(i)).get("date");
//				Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(d);
//
//				
//				
//				
//			}
String a ="";

ArrayList <commentData> comments =new ArrayList<>();
for(int i=0;i<commentData.comm.size();i++) {
	if(commentData.comm.get(i).getNewsId().equals(newsId)) {
		comments.add(commentData.comm.get(i));
	}
}
System.out.println("asdfghgd"+commentData.comm);
String name=dbManager.nameOfUser(id);
response.getWriter().append(comments.toString()+"#"+name);
			
			System.out.println("aasas"+commentData.comm);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		

		
	}

}
