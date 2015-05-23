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
 * Servlet implementation class ShowUsersServlet
 */
@WebServlet("/ShowUsersServlet")
public class ShowUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			ArrayList<String> Records = JDBCProject.getUsers();
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
	        writer.println("<body>"); 
	        writer.println("</body>");
	        writer.println("<h1>Current Priveleges</h1><br><br>");

			for (int i =0;  i < Records.size(); i++){
		        writer.println(Records.get(i) + "<br><br>");
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
