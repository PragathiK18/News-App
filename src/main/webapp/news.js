/**
 * 
 */


function showLess(e){
	console.log("show")
	let newsId=e.parentNode.parentNode.parentNode.parentNode.parentNode.id;
	console.log(newsId);
	var xhr=new XMLHttpRequest();

	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
	
	console.log("less");
	}
	
	
	
	
	
	
	
	
	
	}
xhr.open("POST","./myapp/showLess");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("newsId="+newsId);
	

}


function muteCompany(){
	
}

     let box = document.createElement("div");
  box.setAttribute("class", "box");
   box.style.display="none";
document.body.appendChild(box);

  let main = document.createElement("div");
 main.setAttribute("class", "main");
  main.setAttribute("id", "main");
  document.body.appendChild(main);
  
  

 
 let i=10;

 function slideCreation(logo,companyName,newsTitle,newsImg,contents,id,likes,date1) {

var whole = document.createElement("div");
  whole.setAttribute("class", "whole");
    whole.setAttribute("id",id );
 main.appendChild(whole);
  
    let header = document.createElement("div");
  header.setAttribute("class", "header");
 whole.appendChild(header);

     let circle = document.createElement("div");
 circle.setAttribute("class", "circle");
 header.appendChild(circle);
 
      let img = document.createElement("img");
  img.setAttribute("class", "img");
    img.setAttribute("src", logo);
circle.appendChild(img);
 
     let name = document.createElement("h4");
  name.setAttribute("class", "name");
  name.innerHTML=companyName;
 header.appendChild(name);
 
 
    let opt = document.createElement("div");
       opt.setAttribute("class", "opt1");
   opt.setAttribute("id", "opt"+i);
   header.appendChild(opt);
   opt.setAttribute("onclick","toggleMenu(this)");
      document.getElementById("opt"+i).innerHTML+="<span class='material-symbols-outlined'>\
more_vert\
</span>";




var popupMenu = document.createElement("div");
popupMenu.setAttribute("id", "popup-menu"+i);
popupMenu.setAttribute("class", "popup-menu1");


var menuList = document.createElement("ul");


  var listItem = document.createElement("li");
  var link = document.createElement("span");
  link.setAttribute("onclick","showLess(this)");
  link.textContent = "Show less like this";
  listItem.appendChild(link);
  menuList.appendChild(listItem);
  
    var listItem = document.createElement("li");
  var link = document.createElement("span");
  link.setAttribute("onclick", "muteCompany()");
  link.textContent = "Mute this company";
  listItem.appendChild(link);
  menuList.appendChild(listItem);


popupMenu.style.display="none";	


popupMenu.appendChild(menuList);


header.appendChild(popupMenu);

 
     let body= document.createElement("div");
  body.setAttribute("class", "body");
whole.appendChild(body);

     let title = document.createElement("h4");
title.setAttribute("class", "title");
 title.innerHTML=newsTitle;
body.appendChild(title);

  let img1 = document.createElement("img");
  img1.setAttribute("class", "img1");
    img1.setAttribute("src", newsImg);
body.appendChild(img1);

     let date= document.createElement("p");
 date.setAttribute("class", "date");
date.innerHTML=date1;
body.appendChild(date);

     let content= document.createElement("p");
 content.setAttribute("class", "content");
 content.setAttribute("onclick","fullNews(this)")
 content.innerHTML=contents;
body.appendChild(content);


    let footer = document.createElement("div");
footer.setAttribute("class", "footer");
 whole.appendChild(footer);
 
   let round = document.createElement("div");
  round.setAttribute("class", "round");
  footer.appendChild(round);
  round.innerHTML += '<i id="heart'+id+'" class="fa-regular fa-heart not_liked " onclick="click_like(this)"></i>';
   
  let likes1= document.createElement("p");
 likes1.setAttribute("class", "likes1");
  likes1.setAttribute("id","like"+i );
 likes1.innerHTML=likes;
round.appendChild(likes1);


   let round1 = document.createElement("div");
   round1.setAttribute("class", "round1");
   round1.innerHTML += '<i class="fa-regular fa-message"></i>';
   footer.appendChild(round1);
   round1.setAttribute("onclick","comments(this)");
   
  let comment= document.createElement("p");
comment.setAttribute("class", "comment");
round1.appendChild(comment);

i=i+1;

}
function getCookie(name) {
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
      const cookie = cookies[i].trim();
      if (cookie.startsWith(name + '=')) {
        return cookie.substring(name.length + 1);
      }
    }
    return null;
  }

 function comments(d){
	 
	
	 
console.log("heyy");
box.style.display="block";

 let newsId = d.parentNode.parentNode.id;
  document.cookie="newsId="+newsId;
console.log(newsId);

		var xhr=new XMLHttpRequest();

	

	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
		console.log("done");
		main.style.display="none";	
		 const [commentJson, name] = this.responseText.split('#'); // split the response text into an array and extract the comments JSON object and name
    const temp1 = JSON.parse(commentJson);
    console.log(name);
         //temp0=temp0.split("#");
box.innerHTML="";
    let commentBox = document.createElement("div");
commentBox.setAttribute("class", "commentBox");
box.appendChild(commentBox);
 
     let inpDiv = document.createElement("div");
inpDiv.setAttribute("class", "inpDiv");
box.appendChild(inpDiv);

     let inp = document.createElement("input");
inp.setAttribute("class", "inp");
inp.setAttribute("id", "inp1");
inpDiv.appendChild(inp);

     let sub = document.createElement("button");
sub.setAttribute("class", "sub");
sub.innerHTML="Enter";
sub.setAttribute("onclick","sendComment(this)");
inpDiv.appendChild(sub);


     let cancel = document.createElement("div");
cancel.setAttribute("class", "cancel");
cancel.innerHTML="X";
box.appendChild(cancel);
cancel.setAttribute("onclick","remove(this)");

 
		 for(let i =0;i<temp1.length;i++){
	console.log("sdfghyju");
	
	let cDiv= document.createElement("div");
cDiv.setAttribute("class", "cDiv");
box.firstChild.appendChild(cDiv);

let one= document.createElement("div");
one.setAttribute("class", "one");
one.innerText=temp1[i]["userName"].slice(0,1).toUpperCase();
cDiv.appendChild(one);


let mess= document.createElement("p");
mess.setAttribute("class", "mess");
 mess.innerHTML+=temp1[i]["comment"];
cDiv.appendChild(mess);

let date= document.createElement("p");
date.setAttribute("class", "date2");
date.innerHTML+=temp1[i]["date"];
cDiv.appendChild(date);
	
		}

			
		}
	}
	console.log("pragathi");
	
xhr.open("POST","./myapp/comment");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("newsID="+newsId);


	 
 }
 
  function remove(s){
	 console.log(s.parentNode.innerHTML);
	s.parentNode.style.display="none";	
	document.getElementById("main").style.display="flex";

 }
 
function sendComment(b){
	
    let box=b.parentNode.parentNode.firstChild;
	let inputValue=document.getElementById("inp1");
	let newsId=b.parentNode.parentNode.parentNode.parentNode.parentNode.id;
	console.log(newsId);
		console.log(box);
	var xhr=new XMLHttpRequest();

	

	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
		
console.log(this.responseText);

let cDiv1= document.createElement("div");
cDiv1.setAttribute("class", "cDiv1");
box.appendChild(cDiv1);

let one1= document.createElement("div");
one1.setAttribute("class", "one1");
one1.innerHTML=this.responseText.slice(0,1).toUpperCase();
cDiv1.appendChild(one1);

let mess1= document.createElement("p");
mess1.setAttribute("class", "mess1");
mess1.innerHTML+=inputValue.value;
cDiv1.appendChild(mess1);
inputValue.value="";

let date= document.createElement("p");
date.setAttribute("class", "date2");

let options = { day: '2-digit', month: '2-digit', year: 'numeric' };
let formattedDate = new Date().toLocaleDateString('en-GB', options); // format the date as a string in dd-MM-yyyy format

date.innerHTML+=formattedDate;
cDiv1.appendChild(date);			
		}
	}
	console.log(getCookie("newsId"));
	
xhr.open("POST","./myapp/addComment");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("comments="+inputValue.value+"&newsId="+getCookie("newsId"));

	
	
	
}
let index=0;
 function click_like(a){
	 
	 console.log("asdf");

	if(a.className=="fa-regular fa-heart not_liked "){

		a.className="fa-solid fa-heart liked";
		 addLikes(a,+1);
		
			
	}else{

		a.className="fa-regular fa-heart not_liked ";
		addLikes(a,-1);
		
		
		//console.log(a.className+" "+a)
 }
 }
 

window.onload=function (){

		var xhr=new XMLHttpRequest();

	

	xhr.onreadystatechange= function(){
		console.log(this.responseText);	
		if (xhr.readyState === 4 && xhr.status === 200){

		console.log(this.readyState);
		
			let temp = this.responseText;
		if(temp==="./newLogin.html"){
			window.location.href="newLogin.html";
		}
          temp = JSON.parse(temp).reverse();
         console.log(temp);
		
		 for(let i =0;i<temp.length;i++){
	let date=temp[i]["date"];
	date=date.split("-");
	let date1=date[2]+"-"+date[1]+"-"+date[0];
	console.log("pragathi");
		 slideCreation(temp[i]["logo"],temp[i]["companyName"],temp[i]["newsTitle"],temp[i]["newsImg"],temp[i]["newsContent"],temp[i]["id"],temp[i]["likes"],date1) ;
				
		}
		loadLikes();
		console.log("entering manager");
		  manager ();
			
		}
	}
	
	xhr.open("POST","./myapp/news");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("Newsrequested=");

	 	
}



function addLikes(b,d){

console.log("entre");
	
let newsId = b.parentNode.parentNode.parentNode.id;
	

        var nextElement = b.nextElementSibling;
         var nextElementId = nextElement.id;
		var xhr=new XMLHttpRequest();

		console.log(nextElement);

	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
console.log(b);
	
			let tem = this.responseText;
            tem= JSON.parse(tem);
            console.log(tem);
          //  nextElementId.innerText=tem;
          document.getElementById(nextElementId).innerHTML=tem;


		}
	}
	console.log("pragathi");
	
xhr.open("POST","./myapp/likes");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("newsID="+newsId+"&d="+d);

	 	
return newsId;

	
}






function manager (){
	
console.log("entered manager");

		var xhr=new XMLHttpRequest();

	xhr.onreadystatechange= function(){
			
		if (xhr.readyState === 4 && xhr.status === 200){
		
			let temp = this.responseText;
			console.log(temp);
			temp = JSON.parse(temp);

		  let  val1=temp.id;
		  
		  let val2=temp.role;
		  let val3=temp.status;
		  console.log(val1);
		  console.log(val2);
          console.log(val3);
		  if(val2=="manager" && val3=="approve"){
			  
			  addEditor();
 
		  }else if(val2=="editor"){
			  
			  addNews();
		  }else if(val3=="waitingList"){
			  	  addEditor1();
			 
			  
		  }else if(val2=="admin"){
			  
			  approve();
			  payment();
		  }	
		}
	}
	
xhr.open("POST","./myapp/checkRole");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("Newsrequested=");

	 	
}

 function goToEditorPage(){
	

	console.log("dftghj");
	window.location.href="addEditor.html";
	
}

 function goToNewsPage(){
	

	window.location.href="addNews.html";
	
}

function addEditor(){
	
	console.log("enterd add editor");
let head=document.getElementById("header");
	
let addEditor = document.createElement("div");
addEditor.setAttribute("id", "addEditor");
addEditor.setAttribute("onclick", "goToEditorPage()");
head.appendChild(addEditor);


document.getElementById("addEditor").innerHTML+="<span class='material-symbols-outlined editor'>\
edit_document\
</span>";
	let p=document.createElement("p");
	p.setAttribute("class","e1");
	p.innerHTML="ADD EDITOR ";
	addEditor.appendChild(p);



}

function addNews(){
	console.log("enterd add news");	
	
let head=document.getElementById("header");
	
let addNews = document.createElement("div");
addNews.setAttribute("id", "editor1");
addNews.setAttribute("onclick", "goToNewsPage()");

head.appendChild(addNews);

document.getElementById("editor1").innerHTML+="<span class='material-symbols-outlined editor'>\
edit_document\
</span>";
	let p=document.createElement("p");
	p.setAttribute("class","e");
	p.innerHTML="ADD NEWS ";
	addNews.appendChild(p);

}

function addEditor1(){

let head=document.getElementById("header");
	
let addNews = document.createElement("div");
addNews.setAttribute("id", "editor1");
addNews.setAttribute("onclick", "wait1()");

head.appendChild(addNews);

document.getElementById("editor1").innerHTML+="<span class='material-symbols-outlined editor'>\
edit_document\
</span>";
	let p=document.createElement("p");
	p.setAttribute("class","e");
	p.innerHTML="ADD EDITOR ";
	addNews.appendChild(p);
	
		let wait = document.createElement("div");
wait.setAttribute("id", "wait");
wait.style.display="none";
document.body.appendChild(wait);

	let p1=document.createElement("p");
	p1.setAttribute("class","p1");
	p1.innerHTML="Access Denied";
	wait.appendChild(p1);
	

	
	console.log("enterd add news");	

}

function approve(){
	
	console.log("enterd add magaer");
let head=document.getElementById("header");
	
let addManager = document.createElement("div");
addManager.setAttribute("id", "manager");
addManager.setAttribute("onclick", "goToManagerPage()");	
head.appendChild(addManager);	

document.getElementById("manager").innerHTML+="<span class='material-symbols-outlined editor'>\
edit_document\
</span>";	
	
	let p=document.createElement("p");
	p.setAttribute("class","m");
	p.innerHTML="ADD MANAGER ";
	addManager.appendChild(p);	

	
}

function payment(){
		console.log("enterd add pay");
let head=document.getElementById("header");
	
let payDiv = document.createElement("div");
payDiv.setAttribute("id", "payDiv");
payDiv.setAttribute("onclick", "paymentPage()");	
head.appendChild(payDiv);	

document.getElementById("payDiv").innerHTML+="<span class='material-symbols-outlined editor'>\
edit_document\
</span>";	
	
	let p1=document.createElement("p");
	p1.setAttribute("class","m1");
	p1.innerHTML="PAYMENT";
	payDiv.appendChild(p1);	

}
function paymentPage(){
	
	window.location.href="paymentPage.html";
	
}
function goToManagerPage(){
	
	console.log("go to manager page");
	
	window.location.href="addManager.html";
	
	
	
}

	
function wait1(){
	
 if(document.getElementById("wait").style.display=="block"){
		console.log("one");
		document.getElementById("wait").style.display="none";
	}else{
		console.log("two");
		document.getElementById("wait").style.display="block";
	}


}


function toggleMenu(e) {
  var popupMenu = document.getElementById("popup-menu"+e.id.substring(e.id.length-2,e.id.length));
  console.log("popup-menu"+e.id.substring(e.id.length-2,e.id.length));
  if (popupMenu.style.display === "block") {
    popupMenu.style.display = "none";
  } else {
    popupMenu.style.display = "block";
  }
}

	let category=[
"NEWS","SCIENCE","TECHNOLOGY","BUSINESS","POLITICS","TRAVEL","PHOTOGRAPHY","FOOD","PERSONALFINANCE","CLIMATE","HEALTH","SPORTS","ENTERTAINMENT","LIFESTYLE","HOME&GARDEN","SELF-IMPROVEMENT","COMPUTERSCIENCE","BLACKHISTORY","WORLDECONOMY","CELEBRITYNEWS","DIY","BOOKS","MUSIC","DESIGN","RUSSIA-UKRAINEWAR","BREAKTHROUGHS","PSYCHOLOGY","FASHION","ENTREPRENEURSHIP","CONSERVATIVEVIEW","LIBERALVIEW","OUTDOORS","FITNESS","PRODUCTIVITY","HOW-TO","SPACE","NUTRITION","SLEEP","DOGS","TV","FOREIGNPOLICY","INNOVATION","AUTOS","EDUCATION","HUMOR","PARENTING","THEBRAIN","GAMING","COFFEE","BEAUTY","CULTURE","GADGETS","ARCHITECTURE","CRAFTING","SUSTAINABILITY","HISTORY","STARTUPS","CREATIVITY","STREETART","CALIFORNIA","RELATIONSHIPS","MILITARY","NATURE","APPLE","SHOPPING","THEFUTURE","INTERNET","SOCIALMEDIA"
];


	let myOptions = document.createElement("div");
myOptions.setAttribute("id", "myOptions");
let myButton=document.getElementById("myButton");
myButton.appendChild(myOptions);
document.getElementById("myOptions").style.display="none";

	let popular = document.createElement("p");
popular.setAttribute("id", "pop");
popular.innerHTML="Popular Topics";
myOptions.appendChild(popular);


for(i=0; i<category.length;i++){

let choice = document.createElement("div");
choice.setAttribute("onclick", "categoryChoice(this)");
choice.setAttribute("id",category[i]);
choice.setAttribute("class","sameCategory");
choice.innerText=category[i];
myOptions.appendChild(choice);
}

const button = document.getElementById("myButton");
const options = document.getElementById("myOptions");

button.addEventListener("click", () => {
  if (options.style.display === "none") {
    options.style.display = "block";
  } else {
    options.style.display = "none";
  }
});


function loadLikes(){


		var xhr=new XMLHttpRequest();

	

	xhr.onreadystatechange= function(){
		console.log("likessssssssssss");	
		if (xhr.readyState === 4 && xhr.status === 200){
let likes=this.responseText;
let likeList=likes.replace("[","").replace("]","");
likeList=likeList.split(",");
console.log(likeList);
for(i=0;i<likeList.length;i++){
	
	document.getElementById("heart"+likeList[i].replace(" ","")).className="fa-solid fa-heart liked";
	
}

		}
	}
	console.log("pragathi");
	
xhr.open("POST","./myapp/loadLikes");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("newsID=");



	
}


function categoryChoice(e){

let categoryId=e.id;
console.log(categoryId);
		var xhr=new XMLHttpRequest();
       xhr.onreadystatechange= function(){
	if (xhr.readyState === 4 && xhr.status === 200){
	let categoryNews=this.responseText;
	         categoryNews = JSON.parse(categoryNews);
	document.getElementById("main").innerHTML="";         
         console.log(categoryNews);
		
		 for(let i =0;i<categoryNews.length;i++){
	console.log("category new entered");
		 slideCreation(categoryNews[i]["logo"],categoryNews[i]["companyName"],categoryNews[i]["newsTitle"],categoryNews[i]["newsImg"],categoryNews[i]["newsContent"],categoryNews[i]["id"],categoryNews[i]["likes"],categoryNews[i]["date"]) ;
				
		}

	
		}
	}
	console.log("pragathi");
	
xhr.open("POST","./myapp/categoryChoice");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("categoryId="+categoryId);

}





function dailyEdition(){

console.log("qwerty");

		var xhr=new XMLHttpRequest();
       xhr.onreadystatechange= function(){
	if (xhr.readyState === 4 && xhr.status === 200){
	let dailyEdition=this.responseText;
	        dailyEdition = JSON.parse(dailyEdition);
	         
         console.log(dailyEdition);
		document.getElementById("main").innerHTML="";       
		 for(let i =0;i<dailyEdition.length;i++){
	console.log("daily edition entered");
		 slideCreation(dailyEdition[i]["logo"],dailyEdition[i]["companyName"],dailyEdition[i]["newsTitle"],dailyEdition[i]["newsImg"],dailyEdition[i]["newsContent"],dailyEdition[i]["id"],dailyEdition[i]["likes"],dailyEdition[i]["date"]) ;
				
		}

	
		}
	}
	console.log("pragathi");
	
xhr.open("POST","./myapp/dailyNews");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("categoryId=");

}



function fullNews(e){
	let id=e.parentNode.parentNode.id;
	console.log(id);
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState===4&&xhr.status===200){
		
		let fullDetails=this.responseText;
		fullDetails = JSON.parse(fullDetails);
		console.log(fullDetails);
		console.log(fullDetails[0]['newsTitle']);
		document.getElementById("main").innerHTML="";   
		
		// create the container element
const container = document.createElement("div");
container.classList.add("container");

// create the title element
const title = document.createElement("div");
title.classList.add("title1");
title.textContent = fullDetails[0].newsTitle;
container.appendChild(title);

// create the date element
const date = document.createElement("div");
date.classList.add("date");
date.textContent = fullDetails[0].date;
container.appendChild(date);

// create the image element
const image = document.createElement("img");
image.classList.add("image");
image.src =fullDetails[0].newsImg;
image.alt = "image";
container.appendChild(image);

// create the content element
const content = document.createElement("div");
content.classList.add("content1");

// create the paragraph element for the full content
const fullContent = document.createElement("p");
fullContent.id = "full-content";
fullContent.textContent=fullDetails[0].fullContent;
content.appendChild(fullContent);

// add the content element to the container
container.appendChild(content);

// add the container to the document body
document.body.appendChild(container);

		
		
		
		
		
		}
	}
	xhr.open("POST","./myapp/fullNews");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
xhr.send("id="+id);
}


const image = document.querySelector('.image');

image.addEventListener('mouseenter', () => {
  image.style.transform = 'scale(1.1)';
});

image.addEventListener('mouseleave', () => {
  image.style.transform = 'scale(1)';
});



// Split the full content into paragraphs
const paragraphs = fullContent.split("\n");

// Loop through the paragraphs and create separate <p> tags for each one
let contentHtml = "";
for (let i = 0; i < paragraphs.length; i++) {
  contentHtml += "<p>" + paragraphs[i] + "</p>";
}

// Display the paragraphs on the page
document.getElementById("full-content").innerHTML = contentHtml;

