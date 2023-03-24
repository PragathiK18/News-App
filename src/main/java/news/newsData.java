package news;

import java.util.ArrayList;

public class newsData {

	int id;
	String logo;
	String companyName;
	String newsTitle;
	String newsImg;
	String content;
	String category;
	int likes;
	String date;
	
	public newsData(int id, String logo, String companyName, String newsTitle,String newsImg, String content, String category, int likes,
			String date) {
		super();
		this.id = id;
		this.logo = logo;
		this.companyName = companyName;
		this.newsTitle = newsTitle;
		this.content = content;
		this.category = category;
		this.likes = likes;
		this.date = date;
		this.newsImg=newsImg;
	}
	
	public static ArrayList<newsData> News=new ArrayList<>();
	public ArrayList<Category> myCategory=new ArrayList<>();

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"logo\":\"" + logo + "\", \"companyName\":\"" + companyName + "\", \"newsTitle\":\"" + newsTitle  
				+ "\", \"newsImg\":\"" + newsImg + "\", \"content\":\"" + content + "\", \"category\":\"" + category + "\", \"likes\":\"" + likes
				+ "\", \"date\":\"" + date + "\"}";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
