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
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieID = request.getParameter("id");
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String director = request.getParameter("director");
		String banner_url = request.getParameter("banner_url");
		String trailer_url = request.getParameter("trailer_url");
		String genres = request.getParameter("genres");
		String stars = request.getParameter("stars");

		if (movieID!=null &&  title==null && year==null && director==null && 
		    banner_url==null && trailer_url==null && genres==null && stars==null)
		{
			ArrayList<String> Records = null;
			try {
				Records = JDBCProject.searchMovie(movieID);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String[] parts = Records.get(0).split("~");
			
			 String[] movieList = parts[6].split(",");
			    ArrayList<String> starIDs = new ArrayList<String>();
			    ArrayList<String> starNames = new ArrayList<String>();

			    for (int t = 0; t < movieList.length; t++)
			    {
			      if (t%2==0){
			    	  starIDs.add(movieList[t]);
			      }
			      else{
			    	  starNames.add(movieList[t]);
			      }
			    }

			PrintWriter writer = response.getWriter();
			writer.println("<!DOCTYPE html>");
	        writer.println("<html>");
	        writer.println("<head>");
	        writer.println(
	        		       "<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'></script>"
	        		       + "<link rel='stylesheet' type='text/css' href='movies.css'>"
	        		       + "<script src='movies.js'></script>"
	        		      );
	        writer.println("<title>Search Output </title>");
	        writer.println("</head>");
	        writer.println("<body>");

	        writer.println("<h1>Moviexxx</h1>");
	        writer.println("<div class='selector'>"
	        		+ "<ul>"
	        		+ "<li>"
	        		+ "<input id='c1' type='checkbox'>"
	        		+ "<label for='c1'>asdasdads</label>"
	        		+ "</li>"
	        		+ "<li>"
	        		+ "<input id='c2' type='checkbox'>"
	        		+ "<label for='c2'></label>"
	        		+ "</li>"
	        		+ "<li>"
	        		+ "<input id='c3' type='checkbox'>"
	        		+ "<label for='c3'></label>"
	        		+ "</li>"
	        		+ "</ul>"
	        		+ "<button style='background-image: url('"
	        		+ banner_url
	        		+ "')'></button>"
	        		+ "</div>");
	        writer.println(
			        "<div class='container'>"
	 		 	   + "<img src='"
	 		 	   + parts[4]
	 		 	   +"' onerror='this.onerror=null; this.src=\"movies.jpg\"'"
	 		       + " class='img-circle' width='100' height='110'>"
	 		       + "</div>"+"<br>"
	 		      );
	        writer.println("id : "+parts[0]+"<br>");
	        writer.println("Title :"+parts[1]+"<br>");
	        writer.println("Year : "+parts[2]+"<br>");
	        writer.println("Director : "+parts[3]+"<br>");
	        writer.println("Trailer : "+parts[5]+"<br>");
	        writer.println("Genres : " + parts[7]+"<br>");
	        writer.println("Stars : ");
	        
	        for (int x=0; x < starNames.size(); x++){
		          writer.println("<a href='http://localhost:8080/projecxt/star?"
		        		         + "id="+starIDs.get(x)
		        		         + "'>"
		                         + starNames.get(x)
		                         + "</a>"+" ");	
		        }

	        writer.println("<br>");
	        writer.println("</body>");
	        writer.println("</html>");	
		  
	
		}
		else{
		
		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println(
        		 "<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'></script>"
		       + "<link rel='stylesheet' type='text/css' href='movies.css'>"
		       + "<script src='movies.js'>"
		       + "</script>");
        writer.println("<title>Search Output </title>");
        writer.println("</head>");
        writer.println("<body>");

        writer.println("<h1>Movie</h1>");
        writer.println("<div class='selector'>"
		        		+ "<ul>"
		        		+ "<li>"
		        		+ "<input id='c1' type='checkbox'>"
		        		+ "<label for='c1'></label>"
		        		+ "</li>"
		        		+ "<li>"
		        		+ "<input id='c2' type='checkbox'>"
		        		+ "<label for='c2'></label>"
		        		+ "</li>"
		        		+ "<li>"
		        		+ "<input id='c3' type='checkbox'>"
		        		+ "<label for='c3'></label>"
		        		+ "</li>"
		        		+ "</ul>"
		        		+ "<button style='background-image: url('"
		        		+ banner_url
		        		+ "')'></button>"
		        		+ "</div>");
        writer.println(
				        "<div class='container'>"
		 		 	   + "<img src='"
		 		 	   + banner_url
		 		 	   +"' onerror='this.onerror=null; this.src=\"movies.jpg\"'"
		 		       + " class='img-circle' width='100' height='110'>"
		 		       + "</div>"+"<br>");
        
        writer.println("id : "+movieID);
        writer.println("<br>");
        writer.println("Title : "+ title);
        writer.println("<br>");
        writer.println("Year : " + year);
        writer.println("<br>");
        writer.println("Director : " + director);
        writer.println("<br>");
        writer.println("Trailer : " + trailer_url);
        writer.println("<br>");
        writer.println("Genres : " + genres);
        writer.println("<br>");
        
        writer.println("Stars : ");
        String[] starList = stars.split(",");
	    ArrayList<String> starIDs = new ArrayList<String>();
	    ArrayList<String> starNames = new ArrayList<String>();

	    for (int t = 0; t < starList.length; t++)
	    {
	      if (t%2==0){
	    	  starIDs.add(starList[t]);
	      }
	      else{
	    	  starNames.add(starList[t]);
	      }
	    }
	    
        for (int x=0; x < starNames.size(); x++){
	          writer.println("<a href='http://localhost:8080/projecxt/star?"
	        		         + "id="+starIDs.get(x)
	        		         + "'>"
	                         + starNames.get(x)
	                         + "</a>"+" ");	
	        }

        writer.println("</body>");
        writer.println("</html>");	
	  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
