package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import news.commentData;
import newsApp.ApplicationVariables;
import newsApp.dbManager;
import roles.editor;
import roles.manager;
import roles.user;

/**
 * Servlet implementation class loading
 */
@WebServlet(urlPatterns = "/loading",loadOnStartup = 0)
public class loading extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loading() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	
//
//	try {
//		dbManager.getdbConnection();
//		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("select * from users ");
//		ResultSet set=pt1.executeQuery();
//		
//		while(set.next()) {
//			String id=set.getString(1);
//			String username=set.getString(2);
//			String password=set.getString(3);
//			String mailId=set.getString(4);
//			String number=set.getString(5);
//			String comapnyId=set.getString(6);
//			String role=set.getString(7);
//			String status=set.getString(8);
//			
//			if(role.equals("user")) {
//				user currentlyLogged= new user(id,username,password,mailId,number);
//			      user.usersMap.put(id,currentlyLogged);
//				  
//			}else if(role.equals("manager")) {
//				PreparedStatement pt2= ApplicationVariables.dbConnection.prepareStatement("select * from company where cId =? ");
//				pt2.setString(1,comapnyId);
//				
//				ResultSet set2=pt2.executeQuery();
//				if(set2.next()) {
//					
//					 String cId=set2.getString(1);
//					 System.out.println(cId);
//                     String cName=set2.getString(2);
//                     String cAdress=set2.getString(3);
//                     String cNumber=set2.getString(4);
//                   
//                     user.usersMap.put(id, new manager( id,username, password, mailId, number,cName, cId,cAdress,cNumber,status));
//                     System.out.println("abc"+new manager( id,username, password, mailId, number,cName, cId,cAdress,cNumber,status).getcEmail());
//				}
//			
//				
//				
//			}else if (role.equals("editor")) {
//				
//				editor currentlyLogged=new editor(id,username,password,mailId,number);
//			      user.usersMap.put(id,currentlyLogged);
//				
//			}
//			
//			
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}catch(Exception e) {
//		
//		e.getMessage();
//		
//		
//	}
//	
//	
	try {
		dbManager.getdbConnection();
		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("select * from comment ");
		ResultSet set=pt1.executeQuery();
		
		while(set.next()) {
			System.out.println("1");
			String userId=set.getString(1);
			String newsId=set.getString(2);
			String comments=set.getString(3);
			String time=set.getString(4);
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(time);
			commentData.comm.add(new commentData(userId,newsId,comments,date1));
			
			
			
			
			
			
		}
	}catch(Exception e) {
		System.out.println("aa"+e.getMessage());
		e.getMessage();
		
		
	}
	
	try {
		dbManager.getdbConnection();
			PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("select * from category ");
			ResultSet set=pt1.executeQuery();
		while(set.next()) {
			String sessionId=set.getString(1);
		String [] category=set.getString(2).split(",");
		for(int i=0;i<category.length;i++) {
			user.usersMap.get(sessionId).categories.add(category[i]);
		}
			
		}
		
	}catch(Exception e) {
		
		e.getMessage();
		
		
	}
	
	
	try {
		dbManager.getdbConnection();
		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("select * from comment ");
		System.out.println("1");
		ResultSet set=pt1.executeQuery();
	while(set.next()) {
	String userId=set.getString(1);
    String newsId=set.getString(2);
	String comments=set.getString(3);
	String time=set.getString(4);
	
	System.out.print("sedrftgyuhjik"+comments);
	Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(time);
	commentData.comm.add(new commentData(userId,newsId,comments,date1));
	
		
	}
	
}catch(Exception e) {
	System.out.println(e.getMessage());
	e.getMessage();
	
	
}
	
	
	
	
	try {
		newsApp.dbManager.getdbConnection();

		PreparedStatement ps;
		System.out.println("qwertyuiopkjhgdsasdfghjlbvcxzxcvbnm");
		ps = ApplicationVariables.dbConnection.prepareStatement("SELECT companyName, SUM(likes) as total_likes FROM news GROUP BY companyName");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
		   
		    String companyName = rs.getString("companyName");
		    int totalLikes = rs.getInt("total_likes");
System.out.println("likesss123"+totalLikes);
		    // Check if the company has crossed the threshold
		    if (totalLikes >= 1) {
		        // Calculate the payment amount based on the total number of likes
		        BigDecimal paymentAmount = calculatePaymentAmount(totalLikes);

		        // Insert a new payment record into the payments table
		        PreparedStatement ps2 = ApplicationVariables.dbConnection.prepareStatement("INSERT INTO payments (companyId, paymentAmount, paymentStatus) VALUES (?, ?,?)");
		        System.out.println("qwert");
		        ps2.setString(1, companyName);
		        ps2.setBigDecimal(2, paymentAmount);
		        ps2.setString(3,"notPaid");
		        ps2.executeUpdate();
		        System.out.println("qscdeg");
		    }
		}



		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		
	}

	
	


	
	
}


private static BigDecimal calculatePaymentAmount(int totalLikes) {
    if (totalLikes < 1) {
        return BigDecimal.ZERO;
    } else if (totalLikes < 3) {
        return new BigDecimal("1000");
    } else if (totalLikes < 5) {
        return new BigDecimal("5000");
    } else {
        return new BigDecimal("10000");
    }
}
}







