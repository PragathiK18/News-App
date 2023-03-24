package roles;

import java.util.ArrayList;
import java.util.HashMap;

import news.Category;

public class user {
  String id;
	String username;
	String password;
	String mailId;
	String number;
	Category category;

	
	public  user(String id,String username, String password, String mailId, String number) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.mailId = mailId;
		this.number = number;

	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public static ArrayList<user> getUsers() {
		return users;
	}
	public static void setUsers(ArrayList<user> users) {
		user.users = users;
	}
	public static HashMap<String, user> getUsersMap() {
		return usersMap;
	}
	public static void setUsersMap(HashMap<String, user> usersMap) {
		user.usersMap = usersMap;
	}

	public static ArrayList<user> users=new ArrayList<>();
	public static HashMap<String,user> usersMap=new HashMap<>();	
	public ArrayList<String> categories=new ArrayList<>();

}
