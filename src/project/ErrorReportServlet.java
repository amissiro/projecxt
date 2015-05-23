package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorReportServlet
 */
@WebServlet("/ErrorReportServlet")
public class ErrorReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String temp = JDBCProject.MoviesNoStars();
		String temp1 = JDBCProject.StarsNoMovies();
		String temp2 = JDBCProject.GenresNoMovies();
		String temp3 = JDBCProject.MoviesNoGenres();
		String temp4 = JDBCProject.StarsNoName();
		String temp5 = JDBCProject.ExpiredCC();
		String temp6 = JDBCProject.SameMovies();
		String temp7 = JDBCProject.SameStars();
		String temp8 = JDBCProject.SameGenres();
		String temp9 = JDBCProject.DOBError();
		String temp10 = JDBCProject.EmailError();

		String[] ids = temp.split(",");
		String[] ids1 = temp1.split(",");
		String[] ids2 = temp2.split(",");
		String[] ids3 = temp3.split(",");
		String[] ids4 = temp4.split(",");
		String[] ids5 = temp5.split(",");
		String[] ids6 = temp6.split("_");
		String[] ids7 = temp7.split("_");
		String[] ids8 = temp8.split("_");
		String[] ids9 = temp9.split(",");
		String[] ids10 = temp10.split(",");

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
        writer.println("<title>Error Report </title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Report</h1>");
        writer.println("<br><p>Following movies with ids don't have stars : </p>");
        
        writer.println("<br><p><a href='#p1'>StarsNoMovies</a>|<a href='#p2'>MoviesNoStars</a>"
        			 + "|<a href='#p3'>MoviesNoGenres</a>|<a href='#p4'>GenresNoMovies</a>"
        		     + "|<a href='#p5'>ExpiredCC</a>|<a href='#p6'>DuplicateMovies</a>"
        		     + "|<a href='#p7'>DuplicateStars</a>|<a href='#p8'>DuplicateGenres</a>"
        		     + "|<a href='#p9'>DOBErrors</a>|<a href='#p10'>EmailError</a></p>");

        for (int i = 0; i < ids.length; i++){
            writer.println(ids[i]+"<br>");

        }
        writer.println("<br><p><a name='p1'></a>Following stars with ids don't have movies : </p>");
        for (int i = 0; i < ids1.length; i++){
            writer.println(ids1[i]+"<br>");

        }
        
        writer.println("<br><p><a name='p2'></a>Genres with the following IDs don't have movies : </p>");
        for (int i = 0; i < ids2.length; i++){
            writer.println(ids2[i]+"<br>");

        }
        
        writer.println("<br><p><a name='p3'></a>Movies with the following IDs don't have genres : </p>");
        for (int i = 0; i < ids3.length; i++){
            writer.println(ids3[i]+"<br>");

        }
         
        writer.println("<br><p><a name='p4'></a>Stars with the following IDs don't have first or last names : </p>");
        for (int i = 0; i < ids4.length; i++){
            writer.println(ids4[i]+"<br>");

        }
         
        writer.println("<br><p><a name='p5'></a>Cards with the following ID's are expired : </p>");
        for (int i = 0; i < ids5.length; i++){
            writer.println(ids5[i]+"<br>");

        }
        
        writer.println("<br><p><a name='p6'></a>Following movie IDs respresent duplicate movies : </p>");
        for (int i = 0; i < ids6.length; i++){
            writer.println(ids6[i]+"<br>");

        }

        writer.println("<br><p><a name='p7'></a>Following star IDs respresent duplicate stars : </p>");
        for (int i = 0; i < ids7.length; i++){
            writer.println(ids7[i]+"<br>");

        }
        
        writer.println("<br><p><a name='p8'></a>Following genre IDs respresent duplicate genres : </p>");
        for (int i = 0; i < ids8.length; i++){
            writer.println(ids8[i]+"<br>");

        }
        
        writer.println("<br><p><a name='p9'></a>Following star IDs have errors in their DOB : </p>");
        for (int i = 0; i < ids9.length; i++){
            writer.println(ids9[i]+"<br>");

        }
        
        writer.println("<br><p><a name='p10'></a>Following star IDs have errors in their DOB : </p>");
        for (int i = 0; i < ids10.length; i++){
            writer.println(ids10[i]+"<br>");

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
