package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TitleServlet
 */
@WebServlet(name = "TitlesServlet", urlPatterns = { "/TitlesServlet" })
public class TitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
        writer.println("<body>");
        writer.println("<h1>Star</h1>");
        
        writer.println("<div class='container'>"
        		     + "<div class='btn-toolbar'>"
        		     + "<div class='btn-group btn-group-sm'><center>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=0&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>0</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=1&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>1</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=2&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>2</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=3&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>3</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=4&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>4</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=5&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>5</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=6&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>6</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=7&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>7</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=8&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>8</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=9&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>9</button></a>");

        
        writer.println("</center><br><br><br>");
        
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=A&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>A</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=B&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>B</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=C&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>C</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=D&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>D</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=E&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>E</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=F&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>F</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=G&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>G</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=H&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>H</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=I&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>I</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=J&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>J</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=K&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>K</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=L&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>L</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=M&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>M</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=N&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>N</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=O&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>O</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=P&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>P</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=Q&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>Q</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=R&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>R</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=S&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>S</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=T&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>T</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=U&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>U</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=V&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>V</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=W&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>W</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=X&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>X</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=Y&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>Y</button></a>");
        writer.println("<a href='http://localhost:8080/projecxt/main?fieldType=title&search=Z&sorted=false&order=false&limit=5&offset=0'><button class='btn btn-default'>Z</button></a>");  
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
