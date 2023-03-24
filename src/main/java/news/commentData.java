package news;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import newsApp.ApplicationVariables;

public class commentData {

	String userId;
	String newsId;
	String comments;
	Date Date1;
	
	
	public commentData(String userId, String newsId, String comments, Date date1) {
		super();
		this.userId = userId;
		this.newsId = newsId;
		this.comments = comments;
		Date1 = date1;
	}
	
public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDate1() {
		return Date1;
	}

	public void setDate1(Date date1) {
		Date1 = date1;
	}

	public static ArrayList<commentData> getComm() {
		return comm;
	}

	public static void setComm(ArrayList<commentData> comm) {
		commentData.comm = comm;
	}

public commentData() {
		// TODO Auto-generated constructor stub
	}

public static  ArrayList <commentData> comm=new ArrayList<>();

public String toString() {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	String dateString = dateFormat.format(Date1);
	return "{\"userName\":\"" + getUserName() + "\", \"comment\":\"" + comments +"\",\"date\":\""+dateString + "\"}";
}


public String getUserName() {
	newsApp.dbManager.getdbConnection();
	PreparedStatement pt;
	try {
		pt = ApplicationVariables.dbConnection.prepareStatement("select username from users where id = ?");
		pt.setString(1,this.userId );
		ResultSet rs=pt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("asd"+e.getMessage());
		e.printStackTrace();
	}
	return null;

}






	
}
