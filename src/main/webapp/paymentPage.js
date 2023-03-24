
window.onload=function (){
	 
	 
	 var xhr=new XMLHttpRequest();

	 	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
		
	if(this.responseText==="./notAdmin"){
	console.log(this.responseText);
	window.location.href="./notAdmin.html";
}
		let details=this.responseText;
		console.log("checking.......");
		console.log(details);
		details=JSON.parse(details);
		console.log(details);
		for( let i=0; i<details.length ; i++){
			
managerDetails(details[i]["paymentId"],details[i]["companyId"],details[i]["paymentAmount"])
			
			
		}

		}
	}
	//console.log("checking.......");
xhr.open("POST","./myapp/payment");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send();

	 
 }
 
 let whole = document.createElement("div");
whole.setAttribute("id", "whole");
document.body.appendChild(whole); 

 let i=1;
 function managerDetails(paymId,comId,payamt){
	 

let main = document.createElement("div");
main.setAttribute("class", "main");
whole.appendChild(main);




let payId = document.createElement("p");
payId.setAttribute("id", "name");
payId.setAttribute("class", "same");
main.appendChild(payId);
payId.innerHTML=paymId;


let compId = document.createElement("p");
compId.setAttribute("id", "mail");
compId.setAttribute("class", "same");
main.appendChild(compId);
compId.innerHTML=comId;

let amt = document.createElement("p");
amt.setAttribute("id", "cId");
amt.setAttribute("class", "same");
main.appendChild(amt);
amt.innerHTML=payamt;



	
let approve = document.createElement("div");
approve.setAttribute("id", comId);	
approve.setAttribute("class","app");
approve.setAttribute("onclick","addHistory(this)");
main.appendChild(approve);	
approve.innerHTML="PAY";







 }

                                             



                                                                                             

                                                                                               






                                                                    
   	                                                                         
  
  
  
   	                                                                         
                                                                      
                                                            
 
 
 
    
    
    
    
    function addHistory(e){
		let a=document.getElementById(e.id);
	let p = a.previousElementSibling;
let text = p.innerText;	
	console.log(text);	
		
let b=a.previousElementSibling.previousElementSibling;
let cName=b.innerHTML;
console.log(cName);
e.parentNode.style.display="none";
       
              var xhr=new XMLHttpRequest();   
       	xhr.onreadystatechange= function(){   
    


















                         
}
      xhr.open("POST","./myapp/history");                                                           
     xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");                    
      xhr.send("cName="+cName+"&amt="+text);                                                                                   
    
    }
                                                                           