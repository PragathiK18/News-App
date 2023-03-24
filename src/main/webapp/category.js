/**
 * 
 */

let category=[
"NEWS","SCIENCE","TECHNOLOGY","BUSINESS","POLITICS","TRAVEL","PHOTOGRAPHY","FOOD","PERSONALFINANCE","CLIMATE","HEALTH","SPORTS","ENTERTAINMENT","LIFESTYLE","HOME&GARDEN","SELF-IMPROVEMENT","COMPUTERSCIENCE","BLACKHISTORY","WORLDECONOMY","CELEBRITYNEWS","DIY","BOOKS","MUSIC","DESIGN","RUSSIA-UKRAINEWAR","BREAKTHROUGHS","PSYCHOLOGY","FASHION","ENTREPRENEURSHIP","CONSERVATIVEVIEW","LIBERALVIEW","OUTDOORS","FITNESS","PRODUCTIVITY","HOW-TO","SPACE","NUTRITION","SLEEP","DOGS","TV","FOREIGNPOLICY","INNOVATION","AUTOS","EDUCATION","HUMOR","PARENTING","THEBRAIN","GAMING","COFFEE","BEAUTY","CULTURE","GADGETS","ARCHITECTURE","CRAFTING","SUSTAINABILITY","HISTORY","STARTUPS","CREATIVITY","STREETART","CALIFORNIA","RELATIONSHIPS","MILITARY","NATURE","APPLE","SHOPPING","THEFUTURE","INTERNET","SOCIALMEDIA"
]
 window.onload=function (){
	
	
	 let box= document.createElement("div");
 box.setAttribute("class", "box");
document.body.appendChild(box);
 
 	  let letters_div = document.createElement("div");
 letters_div.setAttribute("class", "letters-div");
 box.appendChild(letters_div);
 
   	  let flip = document.createElement("h1");
flip.setAttribute("class", "flip");
 letters_div.appendChild(flip);
 flip.innerHTML="WELCOME TO FLIPBOARD";
 

 let words = document.createElement("h4");
 words.setAttribute("class", "words");
letters_div.appendChild(words);
words.innerHTML="Follow what interests you to personalize Flipboard. Follow at least 3 topics before continuing";
 
	  let scroll = document.createElement("div");
  scroll.setAttribute("class", "scroll");
 letters_div.appendChild(scroll);
 
 	  let button_div = document.createElement("div");
  button_div.setAttribute("class", "button-div");
 scroll.appendChild(button_div);
 

	 
	 for(i=0;i<category.length;i++){

  	  let buttons = document.createElement("button");
  buttons.setAttribute("class", "not_choosed");
    buttons.setAttribute("id", "buttons");
      buttons.setAttribute("value", category[i]);
    buttons.setAttribute("onclick", "click_category(this)");
    buttons.innerHTML="#"+category[i];
 button_div.appendChild(buttons);
	
}

 


let submit = document.createElement("button");
 submit.setAttribute("class", "follow");
 submit.setAttribute("onclick", "sendToServlet()");
 submit.innerHTML="FOLLOW 3 TO CONTINUE";
box.appendChild(submit);
 


 
 }
	 






 function click_category(a){
	if(a.className=="clicked"){
		a.className="not_clicked"
	}else{
		a.className="clicked"
		//console.log(a.className+" "+a)
 }
 }
 
 function sendToServlet(){
	 
 const clicked = document.querySelectorAll("button");
  let a=[];
let count=0;
for (let i = 0; i < clicked.length; i++) {

	if(clicked[i].className=="clicked"){
			console.log(clicked[i].value);
			 a.push(clicked[i].value);
			 count=count+1;
	}


}	 
	 
	var xhr=new XMLHttpRequest();

	

	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
		
			if(count>=3){
			window.location.href="./news.html";
			}else{
			alert("choose 3 options");
			}
			
			
		}
	}
	
		xhr.open("POST","./myapp/category");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    xhr.send("a="+a.toString()); 
	 
	 
	
	 
 }