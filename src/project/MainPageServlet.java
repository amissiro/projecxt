package project;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String search[] = request.getParameterValues("search");
		String queryField[] = request.getParameterValues("fieldType");
        String sorted = request.getParameter("sorted");
        String order = request.getParameter("order"); 
        String limit = request.getParameter("limit");
        String offset = request.getParameter("offset");
        
        if (offset.isEmpty()){
           offset = "0";	
        }
        
        int j = 0;
		
        for (int i = 0; i < search.length; i++){
			if (search[i]!=null && !search[i].isEmpty()){
		      j++;
			}
		}
		
        String searchFields[] = new String[j]; int k = 0;
        
        for (int i = 0; i < search.length; i++){
			if (search[i]!=null && !search[i].isEmpty()){
		      searchFields[k]= search[i].replaceAll("'", "") ; 
		      k++;
			}
		}
		try {
			
			PrintWriter writer = response.getWriter();
		    
		    writer.println("<!DOCTYPE html>");
	        writer.println("<html>");
	        writer.println("<head>");
	        writer.println("<title>Search Output </title>");
	        writer.println("<link rel='stylesheet' href='//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css'>"
	        			 + "<script src='//code.jquery.com/jquery-1.10.2.js'></script>"
	        			 + "<script src='//code.jquery.com/ui/1.11.4/jquery-ui.js'></script>"
	        			 + "<link rel='stylesheet' href='/resources/demos/style.css'>"
	        			 + "<link rel='stylesheet' type='text/css' href='infowin.css'>"
	        			 + "<script src='ajaxcart.js'></script><script src='infowindow.js'></script>");
	        
	        writer.println("</head>");
	        writer.println("<body>");
	        writer.println("<h1>Search Result</h1>");  
 	        writer.println("<a href='cart?name=null&qty=null'><h1>MyCart(<span id='total'></span>)</h1></a><br>");
 	        
	        String QURL=""; 	
	        
	        for (int i=0; i < searchFields.length; i++){
	        	QURL = QURL + "search="+searchFields[i]+"&"+"fieldType="+queryField[i]+"&";
	        }
	         QURL = QURL.substring(0, QURL.length() - 1);

		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
		            + QURL + "&sorted=title&order=def&limit="+limit+"&offset="+offset
        			+ "'>"        			
        			+ "Title Sort"
        			+ "</a>"
        		  );
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
		            + QURL + "&sorted=title&order=desc&limit="+limit+"&offset="+offset
        			+ "'>"        			
        			+ "Title Sort Desc"
        			+ "</a>"
        		  );
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
		            + QURL + "&sorted=year&order=def&limit="+limit+"&offset="+offset
        			+ "'>"        			
        			+ "Year Sort"
        			+ "</a>"
        		  );
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
		            + QURL + "&sorted=year&order=desc&limit="+limit+"&offset="+offset
        			+ "'>"        			
        			+ "Year Sort Desc"
        			+ "</a><br>"
        		  );
		    
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
		            + QURL + "&sorted="+sorted+"&order="+order+"&limit=5"+"&offset="+offset
        			+ "'>"        			
        			+ "|5|"
        			+ "</a>"
        		  );
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
        			+ QURL + "&sorted="+sorted+"&order="+order+"&limit=10"+"&offset="+offset
        			+ "'>"        			
        			+ "|10|"
        			+ "</a>"
        		  );
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
        			+ QURL + "&sorted="+sorted+"&order="+order+"&limit=15"+"&offset="+offset
        			+ "'>"        			
        			+ "|15|"
        			+ "</a>"
        		  );
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
        			+ QURL + "&sorted="+sorted+"&order="+order+"&limit=20"+"&offset="+offset
        			+ "'>"        			
        			+ "|20|"
        			+ "</a><br>"
        		  );
		    
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
        			+ QURL + "&sorted="+sorted+"&order="+order+"&limit="+limit+"&offset="+offset.substring(0, offset.length() - 1)
        			+ "'>"        			
        			+ "Prev"
        			+ "</a>"
        		  );
		    
		    writer.println(
        			"<a href = 'http://localhost:8080/projecxt/main?"
        			+ QURL + "&sorted="+sorted+"&order="+order+"&limit="+limit+"&offset="+offset+limit
        			+ "'>"        			
        			+ "Next"
        			+ "</a><br>"
        		  );
	        
		    ArrayList<String> Records = JDBCProject.searchHandler(searchFields,queryField,sorted,order,limit,offset);
			
		    for (int i = 0; i < Records.size(); i++){
		        
		    String[] parsedOutput = Records.get(i).split("~");
      
	        writer.println(
    		        "<div class='container'>"
     		 	   + "<img src='"
     		 	   + parsedOutput[4]
     		 	   +"' onerror='this.onerror=null; this.src=\"movies.jpg\"'"
     		       + " class='img-circle' width='100' height='110'>"
     		       + "</div>"
     		      );
	        
		    String[] stars = parsedOutput[7].split(",");
            String starlst="";
		    for (int t = 0; t < stars.length; t++)
		    {
		      if (t%2!=0){
		   
		    	  starlst = starlst+stars[t]+",";
		      }
		    }
	        
		    writer.println(
		        			"<span id='m"+
		        			+ i+"' onmouseover='showWindow(this.id);' url='"
		        		    + parsedOutput[4] + "' title='"
		        		    + parsedOutput[1] + "' year='"
		        		    + parsedOutput[2] + "' stars='"
		        		    + starlst + "'"
		        			+ " onmouseout='hideWindow(this.id);'"
		        			+ "><a href = 'http://localhost:8080/projecxt/movie?"
		        			+ "id="+parsedOutput[0].replaceAll("'", "")
		        			+ "&title="+parsedOutput[1].replaceAll("'", "")
		        			+ "&year="+parsedOutput[2].replaceAll("'", "")
		        			+ "&director"+parsedOutput[3].replaceAll("'", "")
		        			+ "&banner_url="+parsedOutput[4].replaceAll("'", "")
		        			+ "&trailer_url="+parsedOutput[5].replaceAll("'", "")
		        			+ "&genres="+parsedOutput[6].replaceAll("'", "")
		        			+ "&stars="+parsedOutput[parsedOutput.length-1].replaceAll("'", "")
		        			+ "'>"
		        			+ parsedOutput[1]+"</a></span><br>"
		        		    + "<div style='display:none;' id='xxm"+i+"'>"
		      		 	    + "<img src='"+ parsedOutput[4]+"' onerror='this.onerror=null; this.src=\"movies.jpg\"'"
		     		        + " class='img-circle' width='100' height='110'><br>"
		     		        + "Title : " + parsedOutput[1]+"<br>"
		     		        + "Year : "  + parsedOutput[2]+"<br>"
		     		        + "Star : "  + starlst
		        			+ "</div>"
		        		  );
		    
		    String[] starsList = parsedOutput[7].split(",");
		    ArrayList<String> starIDs = new ArrayList<String>();
		    ArrayList<String> starNames = new ArrayList<String>();

		    for (int t = 0; t < starsList.length; t++)
		    {
		      if (t%2==0){
		    	  starIDs.add(starsList[t]);
		      }
		      else{
		    	  starNames.add(starsList[t]);
		      }
		    }
		       
	        writer.println("<br>"+"Movie ID : "+parsedOutput[0]);
	        writer.println("<br>"+"Year : "+parsedOutput[2]);	
	        writer.println("<br>"+"Director : "+parsedOutput[3]);	
	        writer.println("<br>"+"Genres : "+parsedOutput[6]);
	        writer.println("<br>"+"Stars : ");
	        
	        for (int x=0; x < starNames.size(); x++){
	          writer.println("<a href='http://localhost:8080/projecxt/star?"
	        		         + "id="+starIDs.get(x)
	        		         + "'>"
	                         + starNames.get(x)
	                         + "</a>"+" ");	
	        }
	        
	        writer.println("<br>");
	        writer.println("<button id='opt"+i+"' value='"+parsedOutput[1]+"' onClick='generateAutoComplete(this.id);'>Add to Cart</button></a>"); 
	        writer.println("<br>");
	        writer.println("<br><br><br>");
	        parsedOutput=null;
	     }
	        writer.println("</body>");
	        writer.println("</html>");
	       
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}
