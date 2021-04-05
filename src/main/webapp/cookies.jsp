<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<div>
<div class="d-flex align-content-around flex-wrap justify-content-center" id='history'></div>
</div>

    

	<script type="text/javascript">
function getCookie() {
	let cookie = document.cookie;
	if (cookie !== ""){
		cookie.split("; ").forEach(c =>{
			cDisplay = c.split("=")
			cookieElements = cDisplay[1].split("@");
			let test = document.getElementById("cityName").innerHTML;
			let test2 = decodeURI(cookieElements[0]);
			
			if(!test.includes(test2)){
				let card = document.createElement("div");
				card.classList.add("card");
				card.classList.add("text-center")
				card.style.width = "150px";
				card.style.margin = "4px";
				
				let cardBody = document.createElement("div");
				cardBody.classList.add("card-body");
				
				let title = document.createElement("h6");
				title.classList.add("card-title");
				title.append(decodeURI(cookieElements[0].toUpperCase()));
				
				let footer = document.createElement("div");
				footer.classList.add("card-footer");
				footer.append(cookieElements[2] + "°");
				
				cardBody.appendChild(title)
				card.appendChild(cardBody);
				card.appendChild(footer)
				document.getElementById("history").appendChild(card)
			}
		});	
		
		}

}

</script>