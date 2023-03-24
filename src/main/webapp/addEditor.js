/**
 * 
 */
 
 
 
 function addEditor(){
	 
 var username=document.getElementById("name").value;
	  var password=document.getElementById("password").value;
	  var mailid=document.getElementById("mail").value;
	  var phoneNumber=document.getElementById("number").value;
	  

	 
	 var xhr=new XMLHttpRequest();

	 	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
			console.log(this.responseText);
			if(this.responseText==="./notManager"){
				window.location.href="./notAdmin.html";
			}else{
				alert("EDITOR added succesfully .");
		     console.log("enterd succesfully");
		      window.location.href="./news.html"
		
			}
		

		}
	}
	
xhr.open("POST","./myapp/addEditor");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("username=" + username +"&mailid=" + mailid +"&password=" + password  + "&number=" + phoneNumber);

	 
 }