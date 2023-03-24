
 function signUpAsPublisher(){
	 
	
	 
	  var username=document.getElementById("name").value;
	  var password=document.getElementById("password").value;
	  var mailid=document.getElementById("mail").value;
	  var phoneNumber=document.getElementById("number").value;
	 
	   var companyName=document.getElementById("name1").value;
	    var companyAdress=document.getElementById("adress").value;
	     var companyEmail=document.getElementById("email").value;
	      var companyNumber=document.getElementById("cNumber").value;
	  
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
			
		if (xhr.readyState === 4 && xhr.status === 200){
			
	window.location.href="./chooseCategory.html";

			
		}
	}
	
	xhr.open("POST","publisher");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("username=" + username +"&mailid=" + mailid +"&password=" + password +"&number=" + phoneNumber + "&cName=" +companyName + "&adress=" + companyAdress + "&email=" + companyEmail + "&cNumber=" + companyNumber);
}


	 
	 
 }
 
 