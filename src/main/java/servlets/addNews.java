package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import newsApp.dbManager;

/**
 * Servlet implementation class addNews
 */
@WebServlet("/myapp/addNews")
public class addNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNews() {
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


		
			String a=request.getParameter("news");
			System.out.println("param"+a);
			JSONParser parser = new JSONParser();
			JSONObject jp;
			try {
				jp = (JSONObject)parser.parse(a);
				String logo=(String) jp.get("logo");
				String category=(String)jp.get("category");
				String content=(String)jp.get("content");
				String cName=(String)jp.get("cName");
				String newsTitle=(String)jp.get("newsTitle");
				String newsImg=(String)jp.get("newsImg");
				String fullContent=(String)jp.get("fullContent");
				dbManager.addNews(logo,category,content,cName,newsTitle,newsImg,fullContent);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


	 
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
