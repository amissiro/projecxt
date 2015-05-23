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
 * Servlet implementation class SortedMovieList
 */
@WebServlet("/SortedMovieList")
public class GenresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String searchFields[] = request.getParameterValues("seachFileds");
//		String queryFields[] = request.getParameterValues("queryField");
//		String field = request.getParameter("field");
//		String order = request.getParameter("order");
		PrintWriter writer = response.getWriter();
	    
	    writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1'>"
        		     + "<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>"
        		     + "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js'></script>"
        		     + "<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>");
        writer.println("<title>Search Output </title>");	        
        writer.println("</head>");
        writer.println("<h1>Search Result</h1>");  
		
		try {
			ArrayList<String> Records = JDBCProject.searchGenres();
			
		
		    for (int i = 0; i < Records.size(); i++){
			
			    String[] parts = Records.get(i).split("~");
			    writer.println("<a href='http://localhost:8080/projecxt/movielist?genres="
			            +parts[1]
			    		+ "'>"+parts[1]+"</a><br>");
			    
    		}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
