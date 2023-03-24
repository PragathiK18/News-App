/**
 * 
 */

 function addNews(){
	 
	  var logo =document.getElementById("logo").value;
	  var category=document.getElementById("category").value;
	  var content=document.getElementById("content").value;
	  var cName=document.getElementById("cName").value;
	  var newsTitle=document.getElementById("newsTitle").value;
	  var newsImg =document.getElementById("newsImg").value;
	 
	 var req={};
	     req.logo=document.getElementById("logo").value;
	 	 req.category=document.getElementById("category").value;;
	 	 req.content=document.getElementById("content").value;
	 	 req.cName=document.getElementById("cName").value;
         req.newsTitle=document.getElementById("newsTitle").value;
	 	 req.newsImg=document.getElementById("newsImg").value;
	     req.fullContent=document.getElementById("fullContent").value;
	 	 	 	 	 
	 var xhr= new XMLHttpRequest();
	 
	 xhr.onreadystatechange = function(){
			console.log("asdfgh");
		if (xhr.readyState === 4 && xhr.status === 200){
		if(this.responseText==="./notEditor"){
			window.location.href="./notAdmin.html";
		}else{
			alert("NEWS added succesfully .");
			window.location.href="./news.html";
		}
			
		

		}
	}
	
xhr.open("POST","./myapp/addNews");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("news="+JSON.stringify(req));

	 
 }