function generateAutoComplete(id) {	
//		
		var requestToServlet = new XMLHttpRequest();
		var servletResponse; 
		var word = document.getElementById(id).value;

		requestToServlet.onreadystatechange = function() {	        
	        if (requestToServlet.readyState == 4) {	 
	        	
	        	servletResponse = requestToServlet.responseText; 	        		
	        }
    	};		

    	alert(word);
		requestToServlet.open("POST", "CartServlet", true);
		requestToServlet.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		requestToServlet.send("name="+word+"&qty=1"); 
		word="";
  }