package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname = request.getParameter("uname");
		String host = request.getParameter("host");
		String pass = request.getParameter("pass");
		
		try {
			JDBCProject.addUser(uname,host,pass);
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
	        writer.println("<div class='alert alert-success' role='alert'>Congrats you added the user</div>");
	        writer.println("</body>");
	        writer.println("</html>");  


		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
	        writer.println("<div class='alert alert-danger' role='alert'>Error user exists</div>");
	        writer.println("</body>");
	        writer.println("</html>");
		}

	}

}
