package project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    public static boolean contains_field(String[] fields, String field){
    	
    	for (int i =0 ; i < fields.length; i++){
    		if (fields[i].equals(field)){
    			return true;
    		}
    	}
    	return false;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queryField[] = request.getParameterValues("fieldType");
		String search[] = request.getParameterValues("search");

        String privs = request.getParameter("privs");
        String user = request.getParameter("user");
        String host = request.getParameter("host");

        

        if (contains_field(queryField,"all")==true){
        	String command = queryField[0] + " ALL PRIVILEGES" + " ON *.* " +"TO '" +user + "'@'"+host+"'";
        	System.out.println(command);
        	try {
				JDBCProject.editUser(command);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        else if (contains_field(queryField,"database")==true && contains_field(queryField,"table")==false && contains_field(queryField,"col")==false){
    		
        	String command = queryField[0] + " " + privs + " "  + "ON " + search[0]+".* " +"TO '"+ user + "'@'"+host+"'";
        	System.out.println(command);
        	try {
				JDBCProject.editUser(command);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if (contains_field(queryField,"database")==true && contains_field(queryField,"table")==true && contains_field(queryField,"col")==false){
    		
        	String command = queryField[0] + " " + privs + " "  + "ON " + search[0]+"."+search[1]+ " TO '"+user + "'@'"+host+"'";
        	System.out.println(command);
        	try {
				JDBCProject.editUser(command);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if (contains_field(queryField,"database")==true && contains_field(queryField,"table")==true && contains_field(queryField,"col")==true){
    		
        	String command = queryField[0] + " " + privs + " ("  + search[2]+") "+"ON " + search[0]+"."+search[1] + " TO '"+user + "'@'"+host+"'";
        	System.out.println(command);
        	try {
				JDBCProject.editUser(command);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else if (contains_field(queryField,"sp")==true){
        	
        	String command = queryField[0] + " EXECUTE ON PROCEDURE " + search[0]+"."+search[3] + " TO '"+user + "'@'"+host+"'";
        	System.out.println(command);
        	try {
				JDBCProject.editUser(command);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
