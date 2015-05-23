package project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String direct = request.getParameter("direct");
		String burl = request.getParameter("burl");
		String turl = request.getParameter("turl");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String purl = request.getParameter("purl");
		String genre = request.getParameter("genre");
		
		 try {
				
				boolean login = JDBCProject.insertMovies(title,year,direct, burl, turl, fname, lname, dob, purl, genre);

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
