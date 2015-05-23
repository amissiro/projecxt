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
 * Servlet implementation class StarServlet
 */
@WebServlet("/StarServlet")
public class StarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String starID = request.getParameter("id");
		
		ArrayList<String> Records = null;
		try {
			Records = JDBCProject.searchStar(starID);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		String[] parts = Records.get(0).split("~");
		
		 String[] movieList = parts[5].split(",");
		    ArrayList<String> movieIDs = new ArrayList<String>();
		    ArrayList<String> movieNames = new ArrayList<String>();

		    for (int t = 0; t < movieList.length; t++)
		    {
		      if (t%2==0){
		    	  movieIDs.add(movieList[t]);
		      }
		      else{
		    	  movieNames.add(movieList[t]);
		      }
		    }

		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println(
        		         "<meta name='viewport' content='width=device-width, initial-scale=1'>"
        	  	       + "<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>"
        		       + "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>"
        		       + "<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>"
        		      );
        writer.println("<title>Search Output </title>");
        writer.println("</head>");
        writer.println("<h1>Star</h1>");
        writer.println(
		        "<div class='container'>"
 		 	   + "<img src='"
 		 	   + parts[4]
 		 	   +"' onerror='this.onerror=null; this.src=\"avatar.jpg\"'"
 		       + " class='img-circle' width='100' height='110'>"
 		       + "</div>"+"<br>"
 		      );
        writer.println("id : "+parts[0]+"<br>");
        writer.println("Name :"+parts[1]+" "+parts[2]+"<br>");
        writer.println("DOB : "+parts[3]+"<br>");
        writer.println("Movies : ");
       
        for (int x=0; x < movieNames.size(); x++){
	          writer.println("<a href='http://localhost:8080/projecxt/movie?"
	        		         + "id="+movieIDs.get(x)
	        		         + "'>"
	                         + movieNames.get(x)
	                         + "</a>"+" ");	
	        }
	        
	    writer.println("<hr>");
        writer.println("</body>");
        writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
