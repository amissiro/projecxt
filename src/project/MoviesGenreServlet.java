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
 * Servlet implementation class MoviesGenreServlet
 */
@WebServlet("/MoviesGenreServlet")
public class MoviesGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesGenreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String genres = request.getParameter("genres");
		
		try {
			ArrayList<String> Records = JDBCProject.moviesINGenre(genres);

			    String[] parts = Records.get(0).split("~");
			    String[] movieList = parts[2].split(",");		
			    
			    String searchString = "";
			    searchString = searchString.replaceAll("'", "");
			    for (int i=0; i < movieList.length; i++){
			    
			    	searchString = searchString+"fieldType=title&"+"search="+movieList[i]+"&";
			    	
			    } 	
			    
			    response.sendRedirect("http://localhost:8080/projecxt/main?"+searchString+"sorted=false&"
			    			            + "order=false&limit=5&offset=0");
			    	
			    
			
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
