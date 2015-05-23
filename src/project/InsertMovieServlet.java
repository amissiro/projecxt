package project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertMovieServlet
 */
@WebServlet("/InsertMovieServlet")
public class InsertMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMovieServlet() {
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
		String email = request.getParameter("email");
		String passwd = request.getParameter("psw");
		String fullname = request.getParameter("fname");

 		
        try {
			
			boolean login = JDBCProject.insertMovie(email,passwd,fullname);

			if (login==true)
			{
			 RequestDispatcher view = request.getRequestDispatcher("insertstar.html");
			 view.forward(request, response);
		    }
		    else
		    {	
			 RequestDispatcher view = request.getRequestDispatcher("/emplogin");
			 view.forward(request, response);

		    }
		  } catch (Exception e) {
			// TODO Auto-generated catch block
		   // response.sendRedirect("http://localhost:8080/projecxt/emplogin");
			e.printStackTrace();
		}
	}

}
