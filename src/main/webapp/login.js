/**
 * 
 */

 const container = document.getElementById('container');

//document.getElementById('signUp').addEventListener('click',signUp);
//document.getElementById('signUp1').addEventListener('click',signUp);

function signUp() {
	    
 return validate();

}
//document.getElementById('signIn').addEventListener('click', signIn);
//document.getElementById('signIn1').addEventListener('click', signIn);


 
 
  
 function validate(){
	 

	 
	  var username=document.getElementById("name").value;
	  var password=document.getElementById("password").value;
	  var mailid=document.getElementById("mail").value;
	  var phoneNumber=document.getElementById("number").value;
	
	  
	  console.log(mailid);
	  
	let  validation =true;
		console.log(validation);
	  if (!username) {
		  
  alert("Username is required.");
  validation= false;
}
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
if (!emailPattern.test(mailid)) {
  alert("Invalid email address.");
    validation=false;
}  
	  
	if (password.length < 8) {
  alert("Password must be at least 8 characters long.");
   validation= false;
}  
	
	
if (isNaN(phoneNumber) || phoneNumber.length != 10) {
  alert("Please enter a valid 10-digit phone number.");
  validation= false;
} 

 		
if(validation){
		
	var xhr=new XMLHttpRequest();



	xhr.onreadystatechange= function(){
				
				
		if (xhr.readyState === 4 ){
			
		if(xhr.status==200){
			console.log(document.cookie);
				window.location.href="./chooseCategory.html";
		}
	
	
			
		}
	}
	
		xhr.open("POST","users");
	
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	xhr.send("username=" + username +"&mailid=" + mailid +"&password=" + password + "&number=" + phoneNumber);
}

 
	 	 
	 
 }
 
 
 
 
   
 function signInValidate(){
	 


	  var username=document.getElementById("email").value;
	  var password=document.getElementById("pass").value;

	  
	  
	let  validation =true;
		
 		
if(validation){
		
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange= function(){
			console.log(this.readyState);
			console.log(username);
		if (xhr.readyState === 4){
			
				let u=this.responseText;

          window.location.href="news.html";
				
			
		}
	}
	
		xhr.open("POST","./signIn");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("mailid="+username +"&password=" + password);
}

 }
 
 
 
 
