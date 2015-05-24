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
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<String> names = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieName= request.getParameter("name");
		if (!movieName.equals("null")){
		   names.add(movieName);
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
        writer.println("<title>cart</title>");
        writer.println("<script>var sum =0; function calc(size){ "
        		+ "sum = 0;"
        		+ "for (var i=0; i < parseInt(size); i++){"
        		+ "sum = sum +parseInt(document.getElementById('i'+i).value);}"
        		+ "document.getElementById('output').value = sum*9.99; };"
        		+ "function servUrl(){"
        		+ "var a = sum*9.99;"
        		+ "return 'http://localhost:8080/projecxt/checkout?amount='+a.toString();"
        		+ "}"
        		+ "</script>");
        writer.println("</head>");
        //http://localhost:8080/projecxt/checkout?amount=

        writer.println("<h1>CART</h1><br><br>");

        writer.println("<table style='width:50%'><tr><th>Movie</th><th>Qty</th><th>Total Price </th></tr>");
        
  for (int i=0; i < names.size(); i++){      	    
        writer.println("<tr>");   
        writer.println("<td>"+names.get(i)+ "</td>");
        writer.println("<td><input type='number' id='i"+i+"'></td>");
        writer.println("<td>9.99</td>");
        writer.println("</tr>");
  }
  
   writer.println("</table><br><br><br>");
   writer.println("<center><textarea rows='1' cols='10' style='resize:none; font-size: 12pt' id='output' readonly></textarea>");
   writer.println("<button onclick='calc("+names.size()+")'>count</button><br><br><br><br><br>");
   writer.println("<a href = 'javascript:document.location.href=servUrl();'><button style='height:40px; width:200px'>Checkout</button></a></center>");
   writer.println("</head>");
   writer.println("</title>");
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieName= request.getParameter("name");
		names.add(movieName);
		System.out.println(names);
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
        writer.println("<title>cart</title>");
        writer.println("<script>var sum =0; function calc(size){ "
        		+ "sum = 0;"
        		+ "for (var i=0; i < parseInt(size); i++){"
        		+ "sum = sum +parseInt(document.getElementById('i'+i).value);}"
        		+ "document.getElementById('output').value = sum*9.99; };"
        		+ "function servUrl(){"
        		+ "var a = sum*9.99;"
        		+ "return 'http://localhost:8080/projecxt/checkout?amount='+a.toString();"
        		+ "}"
        		+ "</script>");
        writer.println("</head>");
        //http://localhost:8080/projecxt/checkout?amount=

        writer.println("<h1>CART</h1><br><br>");

        writer.println("<table style='width:50%'><tr><th>Movie</th><th>Qty</th><th>Total Price </th></tr>");
        
   for (int i=0; i < names.size(); i++){      	    
        writer.println("<tr>");   
        writer.println("<td>"+names.get(i)+ "</td>");
        writer.println("<td><input type='number' id='i"+i+"'></td>");
        writer.println("<td>9.99</td>");
        writer.println("</tr>");
  }
  
   writer.println("</table><br><br><br>");
   writer.println("<center><textarea rows='1' cols='10' style='resize:none; font-size: 12pt' id='output' readonly></textarea>");
   writer.println("<button onclick='calc("+names.size()+")'>count</button><br><br><br><br><br>");
   writer.println("<a href = 'javascript:document.location.href=servUrl();'><button style='height:40px; width:200px'>Checkout</button></a></center>");
   writer.println("</head>");
   writer.println("</title>");
	
	}

}
