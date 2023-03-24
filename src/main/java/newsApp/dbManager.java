package newsApp;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import newsApp.ApplicationVariables;
import javax.servlet.http.Cookie;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import news.Category;
import roles.editor;
import roles.manager;
import roles.user;
import servlets.users;

import servlets.category;
public class dbManager {

	public static void getdbConnection() {
		if(ApplicationVariables.dbConnection==null) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			ApplicationVariables.dbConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/newsApp","pragathi","pragathi@18");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	public static void addUser(user currentlyLogged) {
		
	  System.out.println(currentlyLogged);
		getdbConnection();
	
				try {
			PreparedStatement pt= ApplicationVariables.dbConnection.prepareStatement("insert into users (id,username,password,mailId,number,role) values(?,?,?,?,?,?)");
			pt.setString(1, currentlyLogged.getId());
			pt.setString(2, currentlyLogged.getUsername());
			pt.setString(3, currentlyLogged.getPassword());
			pt.setString(4, currentlyLogged.getMailId());
			pt.setString(5, currentlyLogged.getNumber());
			pt.setString(6, "user");
			
			
			
			pt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

				
		
		
		
	}

	public static void addCategory(String id,String a1) {
		// TODO Auto-generated method stub
		getdbConnection();
		try {
			PreparedStatement pt= ApplicationVariables.dbConnection.prepareStatement("insert into category (userid,category) values(?,?)");
			pt.setString(1, id);
			pt.setString(2, a1);

			pt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}	

	}
	
	public static JSONArray showNews(String id) throws SQLException {
		System.out.println("entered show news");
		getdbConnection();
		
					Statement pt= ApplicationVariables.dbConnection.createStatement();
					ResultSet set = pt.executeQuery("select * from category where userId = \""+id+"\"");
				     System.out.println("qwerty"+id);
						if(set.next()) {
							System.out.println("entered next");
							String [] categoryList= set.getString(2).split(",");
							JSONArray arr = new JSONArray();
							System.out.println(set.getString(2)+"asdf");
							for(int i=0;i<categoryList.length;i++) {
								
								PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("select * from news where category = ? order by id desc");
								pt3.setString(1,categoryList[i]);
								ResultSet set1=pt3.executeQuery();
								String data="";
				
								int j=0;
				
								while(set1.next()) {
									
									JSONObject json = new JSONObject();	
					
										json.put("id",set1.getInt(1) );
										json.put("logo",set1.getString(2) );
										json.put("companyName",set1.getString(3) );
										json.put("newsTitle",set1.getString(4) );
										json.put("newsImg",set1.getString(5) );
										json.put("newsContent",set1.getString(6) );
										json.put("category",set1.getString(7) );
										json.put("likes",set1.getString(8) );
										json.put("date",set1.getString(9) );
										
									
										arr.add(json);
										
							
								}
							}
							
							System.out.println(arr);
							return arr;
						}else 
					if(!set.next()) {
						System.out.println("entered not next");
					JSONArray arr = new JSONArray();
		
					PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("select * from news");
					ResultSet set1=pt3.executeQuery();
	;
			
							while(set1.next()) {
								
								JSONObject json = new JSONObject();	
				
									json.put("id",set1.getInt(1) );
									json.put("logo",set1.getString(2) );
									json.put("companyName",set1.getString(3) );
									json.put("newsTitle",set1.getString(4) );
									json.put("newsImg",set1.getString(5) );
									json.put("newsContent",set1.getString(6) );
									json.put("category",set1.getString(7) );
									json.put("likes",set1.getString(8) );
									json.put("date",set1.getString(9) );
									
								
									arr.add(json);
									
						
							}
							return arr;
					}

					return null;
							
						
							

		
		
		
		
		
		
	}
	
	
	public static JSONObject checkRole(String id) {
		
		getdbConnection();
		
		
		try {
			
			PreparedStatement pt=ApplicationVariables.dbConnection.prepareStatement("select role ,status from users where id = ? ");
			pt.setString(1, id);
			ResultSet set=pt.executeQuery();
			System.out.println(id+"id here!!");
			 JSONObject json = new JSONObject();	
		if(set.next()) {
			
			String role=set.getString(1);
			String status=set.getString(2);
			System.out.println(role+"jj");
			json.put("id", id);
			json.put("role", role);
			json.put("status", status);
			
			System.out.println("hello");
		}
		
		return json;
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		

		
		
	}
	
	
public static String likes(int newsId,int d) {
	
	getdbConnection();
	
	int likes=0;
	try {
		PreparedStatement 	pt = ApplicationVariables.dbConnection.prepareStatement("select likes from news where id = ?");
	pt.setInt(1,newsId);
		  ResultSet set= pt.executeQuery();
		  if(set.next()) {
			  likes = set.getInt(1);
			  
			  
			  
			  
			  
		  }
		
		System.out.print("sdfgtyhujnvcfy");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println(e1.getMessage());
//		e1.printStackTrace();
	}

	
	
try {
System.out.print("sdfgtyhujnvcfy");
PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("update news  set likes =?  where id = ?");
pt1.setInt(1, likes+d);
pt1.setInt(2, newsId);
pt1.executeUpdate();

return(likes+d+"");

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
System.out.println(e.getMessage());
}




	return null;

	
}
	
	
public static String comment(String newsId) {
	getdbConnection();
	
		String role="";
		try {
		PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("select * from comment where newsId = ? order by time desc ");
		pt3.setString(1,newsId);
		
		System.out.print("helsghsdicd"+newsId);
		
		ResultSet set1=pt3.executeQuery();
		JSONArray arr = new JSONArray();

		while(set1.next()) {
			
			JSONObject json = new JSONObject();	

				json.put("Userid",set1.getString(1) );
				json.put("Newsid",set1.getString(2) );
				json.put("comment",set1.getString(3) );
				json.put("date",set1.getString(4) );
				arr.add(json);
				
				
	
		}
		    System.out.println(arr);
			return arr.toString();
			
		}
		
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	
	return null;
	

}
	
	
public static void addManager(String u,String username,String password,String mailId,String number,String cEmail) {
	getdbConnection();
	
	System.out.println("entered add manager");
	try {
		System.out.println("k1");
		PreparedStatement pt= ApplicationVariables.dbConnection.prepareStatement("insert into users (id,username,password,mailId,number,companyId,role,status) values(?,?,?,?,?,?,?,?)");
		pt.setString(1, u);
		pt.setString(2, username);
		pt.setString(3, password);
		pt.setString(4, mailId);
		pt.setString(5, number);
		pt.setString(6, cEmail);
		pt.setString(7, "manager");
		pt.setString(8, "waitingList");
	
		pt.executeUpdate();
		System.out.println("k2");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("kk");
		System.out.println(e.getMessage());
	}
	

	
}
	

public static void addCompany(String cEmail, String cName, String cAdress, String cNumber) {
	
	getdbConnection();
	
	try {
		PreparedStatement pt=ApplicationVariables.dbConnection.prepareStatement("insert into company (cId,cName,cAdress,cNumber) values(?,?,?,?)");
		pt.setString(1, cEmail);
		pt.setString(2, cName);
		pt.setString(3, cAdress);
		pt.setString(4, cNumber);

		
		
		pt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	
	
	
	
	
}
	
public static String signIn(String mailid) {

	getdbConnection();

	try {
		PreparedStatement st = ApplicationVariables.dbConnection.prepareStatement("select * from users where mailId = ?");
		st.setString(1, mailid);
		ResultSet set1 = st.executeQuery();
		String password1="";
		String role1="";
		String id="";
		if(set1.next()) {
			password1 = set1.getString(3);
			role1=set1.getString(7);
            id=set1.getString(1);
		}
		
		return password1+"%"+id;
	
	}catch(Exception e) {
		
		
		e.getMessage();
	}
	
	
	return null;

}
	


public static JSONArray addManager() {
	
	getdbConnection();
	
	try {
		PreparedStatement pt= ApplicationVariables.dbConnection.prepareStatement("select * from users where role = ? and status=?");
		pt.setString(1, "manager");
		pt.setString(2, "waitingList");
		
		ResultSet set1=pt.executeQuery();
		JSONArray arr = new JSONArray();
		

		while(set1.next()) {
			
			JSONObject json = new JSONObject();		
	
			json.put("username", set1.getString(2));
			json.put("password", set1.getString(3));
			json.put("mailId", set1.getString(4));
			json.put("number", set1.getString(5));
			json.put("companyId", set1.getString(6));
			json.put("role", set1.getString(7));
			json.put("status", set1.getString(8));
			
			arr.add(json);
			
			
		}

	
		return arr;
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	return null;
	

}


public static JSONArray showPay() {
	
	getdbConnection();
	
	try {
		System.out.println("entering showing payyyyyyyyy");
		PreparedStatement pt= ApplicationVariables.dbConnection.prepareStatement("select paymentId , companyId ,paymentAmount from payments");
	
		ResultSet set1=pt.executeQuery();
		JSONArray arr = new JSONArray();
		

		while(set1.next()) {
			
			JSONObject json = new JSONObject();		
			json.put("paymentId", set1.getInt(1));
			json.put("companyId", set1.getString(2));
			json.put("paymentAmount", set1.getString(3));
			arr.add(json);
			
			
		}
System.out.println("asdfg"+arr);
	
		return arr;
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	return null;
	

}







public static void updateManager(String cId,String status) {
	
	getdbConnection();
	//System.out.println(currentlyLogged);
	
try {

PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("update users  set status =?  where mailId = ?");
pt1.setString(1, status);
pt1.setString(2, cId);
int n= pt1.executeUpdate();
System.out.println(pt1);

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
System.out.println(e.getMessage());
}

	
}

public static void addComment(String id, String newsId, String comm,String date ) {
	getdbConnection();
	
	
	try {
		PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("insert into comment (userId , newsId,  comments , time)values (?,?,?,?) ");
		pt3.setString(1,id);
	   pt3.setString(2,newsId);
       pt3.setString(3,comm);
        pt3.setString(4,date);
	
		pt3.executeUpdate();
		
	}catch(Exception e) {
		System.out.println(" not added!!!!!!!!");
		System.out.println(e.getMessage());
	}

	
}



public static void addEditor(editor currentlyLogged) {
	getdbConnection();
	
	try {
		PreparedStatement pt= ApplicationVariables.dbConnection.prepareStatement("insert into users (id,username,password,mailId,number,role) values(?,?,?,?,?,?)");
		pt.setString(1, currentlyLogged.getId());
		pt.setString(2, currentlyLogged.getUsername());
		pt.setString(3, currentlyLogged.getPassword());
		pt.setString(4, currentlyLogged.getMailId());
		pt.setString(5, currentlyLogged.getNumber());
		pt.setString(6, "editor");

		pt.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}

}

public static void showLikes(int newsId,int likes) {
	getdbConnection();
	
	
	try {
		PreparedStatement 	pt = ApplicationVariables.dbConnection.prepareStatement("select likes from news where id = ?");
	pt.setInt(1,newsId);
		  ResultSet set= pt.executeQuery();
		  if(set.next()) {
			  likes = set.getInt(1);
 
		  }
		
		System.out.print("sdfgtyhujnvcfy");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println(e1.getMessage());
//		e1.printStackTrace();
	}
	
}

public static String updateLikes(int likes,int newsId,int d) {
	getdbConnection();
	
	try {
		System.out.print("sdfgtyhujnvcfy");
		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("update news  set likes =?  where id = ?");
		pt1.setInt(1, likes+d);
		pt1.setInt(2, newsId);
		pt1.executeUpdate();
	
		return (likes+d+"");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}

	return null;
	
}

public static void showLess(String id,String newsId) {
	getdbConnection();
	
	String category="";
	String[] c= {};
	String toRemove="";
	String[] newArray= {};
	try {
		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement(" select category from news where id  = ?");
		pt1.setString(1, newsId);
		ResultSet set=pt1.executeQuery();
		  if(set.next()) {
		toRemove=set.getString(1).toUpperCase();
		System.out.println("to removeeeeeeeee"+toRemove.toUpperCase());
		  }
		}catch(Exception e) {
			e.getMessage();
		}
	try {
		System.out.println("entered");
		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement(" select category from category where userId  = ?");
		pt1.setString(1, id);
		ResultSet set=pt1.executeQuery();
		  if(set.next()) {
		category=set.getString(1);
		
		  }
		  c=category.split(",");
		 newArray = new String[c.length - 1];
		  int index = 0;

		  for (int i = 0; i < c.length; i++) {
		      if (c[i].equals( toRemove)) {
		         
		          System.out.println(toRemove+"*********"+c[i]);
		      }else {
		    	  newArray[index++] = c[i];
		      }
		      System.out.println(toRemove+"::::::::"+c[i]);
		  }
		  
		
	}catch(Exception e) {
		e.getMessage();
	}
	
	try {
		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("update category set category = ? where userId =?");
		pt1.setString(1, Arrays.toString(newArray));	
		pt1.setString(2, id);
		
		System.out.print("newArrayyyy"+Arrays.toString(newArray));
		System.out.println("UPDATED");
		
	}catch(Exception e) {
		e.getMessage();
	}
	

}

public static void muteCompany() {
	getdbConnection();
	try {
	
	
	
	
	
	
	
	
	
	
}catch(Exception e) {
	e.getMessage();
}


}

public static   String loadLikes(String id) {
	
	getdbConnection();
	PreparedStatement pt1;
	try {
		pt1 = ApplicationVariables.dbConnection.prepareStatement(" select newsId from likes where userId  = ?");
		pt1.setString(1, id);
		int newsId= 0;
		ArrayList <Integer> b= new ArrayList<>();
		ResultSet set=pt1.executeQuery();
		while(set.next()) {
			
		newsId=set.getInt(1);
	     b.add(newsId);
			
		}
		System.out.println("entered load likes"+b);
		return b.toString();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	

}

public static void addInLikes(String userId,int newsId) {
	getdbConnection();
	try {
		PreparedStatement pt1= ApplicationVariables.dbConnection.prepareStatement("insert into likes (userId,newsId) values (? , ?)");
		pt1.setString(1, userId);
		pt1.setInt(2, newsId);
		System.out.println(pt1);
		int n=	pt1.executeUpdate();
		System.out.println("adddddddddLiessssssssssss"+n);
	}catch(Exception e) {
		System.out.println("r5fgyhbn"+e.getMessage());
		
		
	}
	
	
}

public static  JSONArray chooseCatgory(String choice) {
	getdbConnection();
	try {
		System.out.println("choooseee category enterd");
		JSONArray arr = new JSONArray();
	PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("select * from news where category = ? ");
	pt3.setString(1,choice);
	ResultSet set1=pt3.executeQuery();
System.out.println("choiceee"+choice);

	while(set1.next()) {
		
		JSONObject json = new JSONObject();	

			json.put("id",set1.getInt(1) );
			json.put("logo",set1.getString(2) );
			json.put("companyName",set1.getString(3) );
			json.put("newsTitle",set1.getString(4) );
			json.put("newsImg",set1.getString(5) );
			json.put("newsContent",set1.getString(6) );
			json.put("category",set1.getString(7) );
			json.put("likes",set1.getString(8) );
			json.put("date",set1.getString(9) );
			
		
			arr.add(json);
			System.out.print("category arrayyyy"+arr);

	}
	return arr;
	}catch(Exception e) {
		e.getMessage();
	}
	return null;
}



public static  JSONArray dailyNews() {
	getdbConnection();
	System.out.println("entered daily news");
	try {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(currentDate);
		System.out.println("daaatttttee"+dateString);
		JSONArray arr = new JSONArray();
	PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("select * from news where date = ? ");
	pt3.setString(1,dateString);
	ResultSet set1=pt3.executeQuery();
	String data="";

	int j=0;

	while(set1.next()) {
		
		JSONObject json = new JSONObject();	

			json.put("id",set1.getInt(1) );
			json.put("logo",set1.getString(2) );
			json.put("companyName",set1.getString(3) );
			json.put("newsTitle",set1.getString(4) );
			json.put("newsImg",set1.getString(5) );
			json.put("newsContent",set1.getString(6) );
			json.put("category",set1.getString(7) );
			json.put("likes",set1.getString(8) );
			json.put("date",set1.getString(9) );
			
		
			arr.add(json);
			System.out.println("DDDDDDAAAAAIIIIILLLYYYYYYY"+arr);

	}
	return arr;

	}catch(Exception e) {
		e.getMessage();
	}
	return null;
	
}


public static void addNews(String logo, String category, String content , String cName , String newsTitle , String newsImg , String fullContent) {
	try {
		

		Date currentDate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = dateFormat.format(currentDate);

			PreparedStatement pt=ApplicationVariables.dbConnection.prepareStatement("insert into news (logo , category  , date , newsContent , companyName , newsTitle , newsImg , fullContent) values(?,?,?,?,?,?,?,?)");
			pt.setString(1, logo);
			pt.setString(2, category);
			pt.setString(3, dateString);
			pt.setString(4, content);
			pt.setString(5, cName);
			pt.setString(6, newsTitle);
			pt.setString(7, newsImg);
			pt.setString(8, fullContent);
	
			
		
			
			pt.executeUpdate();
	}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 

}



public static String nameOfUser(String id) {

	getdbConnection();

	try {
		PreparedStatement st = ApplicationVariables.dbConnection.prepareStatement("select username from users where id = ?");
		st.setString(1, id);
		ResultSet set1 = st.executeQuery();
		String name="";
		if(set1.next()) {
            name=set1.getString(1);
		}
		
		return name;
	
	}catch(Exception e) {
		
		
		e.getMessage();
	}
	return null;
	
	

}



public static void history(String cName, String amt) {
	getdbConnection();
	
	
	try {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormat.format(currentDate);

		PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("insert into history (company , amount, date)values (?,?,?) ");
		pt3.setString(1,cName);
	   pt3.setString(2,amt);
       pt3.setString(3,dateString);
      
	
		pt3.executeUpdate();
		
	}catch(Exception e) {
		System.out.println(" not added!!!!!!!!");
		System.out.println(e.getMessage());
	}

	
}

public static void deletePaid(String cName) {
	getdbConnection();
	
	
	try {
		
		PreparedStatement pt3= ApplicationVariables.dbConnection.prepareStatement("delete from payments where companyId = ?");
		pt3.setString(1,cName);
	   
		pt3.executeUpdate();
		
	}catch(Exception e) {
		System.out.println(" not added!!!!!!!!");
		System.out.println(e.getMessage());
	}

	
}

public static JSONArray fullNews(int id) {
	JSONArray arr = new JSONArray();
	
	PreparedStatement pt3;
	try {
		pt3 = ApplicationVariables.dbConnection.prepareStatement("select * from news where id = ?");
		pt3.setInt(1, id);
		ResultSet set1=pt3.executeQuery();

		while(set1.next()) {
			
			JSONObject json = new JSONObject();	

				json.put("id",set1.getInt(1) );
				json.put("logo",set1.getString(2) );
				json.put("companyName",set1.getString(3) );
				json.put("newsTitle",set1.getString(4) );
				json.put("newsImg",set1.getString(5) );
				json.put("newsContent",set1.getString(6) );
				json.put("category",set1.getString(7) );
				json.put("likes",set1.getString(8) );
				json.put("date",set1.getString(9) );
				json.put("fullContent",set1.getString(10) );
				
			
				arr.add(json);
				
	
		}
		return arr;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	return null;
			
		
	
}










}
