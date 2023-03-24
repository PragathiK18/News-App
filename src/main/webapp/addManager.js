
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
			
managerDetails(details[i]["username"],details[i]["mailId"],details[i]["companyId"],details[i]["status"])
			
			
		}

		}
	}
	//console.log("checking.......");
xhr.open("POST","./myapp/addManager",true);
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send();

	 
 }
 let whole = document.createElement("div");
whole.setAttribute("id", "whole");
document.body.appendChild(whole); 

 let i=1;
 function managerDetails(name1,mailId,cid,Status){
	 

let main = document.createElement("div");
main.setAttribute("class", "main");
whole.appendChild(main);




let name = document.createElement("p");
name.setAttribute("id", "name");
name.setAttribute("class", "same");
main.appendChild(name);
name.innerHTML=name1;
console.log(name+" "+cid+" "+Status+" ");

let mailid = document.createElement("p");
mailid.setAttribute("id", "mail");
mailid.setAttribute("class", "same");
main.appendChild(mailid);
mailid.innerHTML=mailId;

let cId = document.createElement("p");
cId.setAttribute("id", "cId");
cId.setAttribute("class", "same");
main.appendChild(cId);
cId.innerHTML=cid;



let status = document.createElement("p");
status.setAttribute("id", "status");
status.setAttribute("class", "same");
main.appendChild(status);
status.innerHTML=Status;



	
let approve = document.createElement("div");
approve.setAttribute("id", mailId);	
approve.setAttribute("class","app");
approve.setAttribute("onclick","approve(this,'approve')");
main.appendChild(approve);	

document.getElementById(mailId).innerHTML+="<span  class='material-symbols-outlined'>\
done\
</span>"

	

let disapprove = document.createElement("div");
disapprove.setAttribute("id", "disapprove"+i);	
disapprove.setAttribute("class","disapp");
disapprove.setAttribute("onclick","approve(this,'disapprove')");
main.appendChild(disapprove);	

document.getElementById("disapprove"+i).innerHTML+="X"
	i=i+1;	
	 

 }
 
 
 function approve(e,status){
	
	 
	 let cId=e.id;
	  console.log(cId);
	console.log(status);
	 e.parentNode.style.display="none";
	  
	 var xhr=new XMLHttpRequest();

	 	xhr.onreadystatechange= function(){

	 	}
	
xhr.open("POST","./myapp/approveManager");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("cId="+cId+"&status1="+status);
	 

	 
 }