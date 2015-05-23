package project;
import java.sql.*;                              
import java.util.ArrayList;

public class JDBCProject
{
	public static Connection connection;

       public static void connector (String username, String passw) throws Exception
       {
           String userName = username;
           String passwd = passw;
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           connection = DriverManager.getConnection("jdbc:mysql:///moviedb",userName, passwd);
       }
      
       public static int atoi(String element){
   		int sum = 0;
   		for (int i=0; i < element.length(); i++){
   			int x = Character.getNumericValue(element.charAt(i));
              sum = sum+x;
   		}
   		return sum;
      }

      public static boolean isEqualElements(String[] array){
  		for (int i=0; i < array.length; i++){
            if (!array[0].equals(array[i])) return false;
  		}
  		
  		return true;
      }
       
       public static ArrayList<String> searchHandler(String[] name, String[] fields, String sorted, String order,String limit,String offset) throws Exception{
    	 
    	 int num = atoi(offset);
    	       	   
    	 Statement select = connection.createStatement();
         ResultSet result = null;
         String conditionString = "";
         
         for (int i=0;i<name.length; i++)
         {
            if (fields[i].equals("name"))
            {
            	if (name[i].contains(" "))
            	{
            	 String[] parts = name[i].split(" ");
            	 conditionString = conditionString + "first_name"+" like '" + parts[0] 
            			                           + "%' AND last_name like '" + parts[1]
            			                           +"%' AND ";
            	}
            	else 
            	{
            	 conditionString = conditionString + "first_name"+" like '" + name[i] 
	                                               + "%' OR last_name like '" + name[i]
	                                               +"%' AND ";
            	}
            }
            else{

              if (isEqualElements(fields)==true && fields.length > 1){
        	     conditionString = conditionString + fields[i]+" like '" + name[i] + "%' OR ";
              }
              else{
     	       conditionString = conditionString + fields[i]+" like '" + name[i] + "%' AND ";   
              }
            }
         }
         
         conditionString = conditionString.substring(0, conditionString.length() - 4);
         String orderBy = "";
         
         if (!sorted.equals("false") && order.equals("def")){
             orderBy = "ORDER BY " + sorted;

         }
         else if (!sorted.equals("false") && order.equals("desc")){
        	 orderBy = "ORDER BY " + sorted + " desc";
         }
         else{
        	 orderBy="";
         }
        result = select.executeQuery(
                                      "SELECT "
                                     + "m.id, m.title, m.year,m.director, m.banner_url, m.trailer_url, "
                                     + "group_concat(distinct gs.name separator ','), "
                                     + "group_concat(distinct s.id, ',' ,s.first_name, ' ',s.last_name ) "
                                     + "FROM movies m "
                                     + "LEFT JOIN stars_in_movies sm on sm.movie_id = m.id "
                                     + "LEFT JOIN stars s ON s.id = sm.star_id "
                                     + "LEFT JOIN genres_in_movies g ON g.movie_id = sm.movie_id "
                                     + "LEFT JOIN genres gs ON gs.id = g.genre_id "
                                     + "WHERE "
                                     + conditionString
                                     + " group by m.id "
                                     + orderBy
                                     + " limit "+limit + " offset " + num 
                                    );
   
         ArrayList<String> Records = new ArrayList<String>();
         if (!result.next()) {
  	       System.out.println("No record found");
         }
         else{
  	          do
              {
               String resultRecord = result.getString(1)+"~"+result.getString(2)+"~"+
                                     result.getString(3)+"~"+result.getString(4)+"~"+
                                     result.getString(5)+"~"+result.getString(6)+"~"+
                                     result.getString(7)+"~"+result.getString(8);                             
               Records.add(resultRecord); 
               resultRecord="";               
              }while (result.next());
             }
		return Records; 
     }
       
       private static boolean isEqualArray(String[] fields) {
		// TODO Auto-generated method stub
		return false;
	}

	public static ArrayList<String> searchStar(String SID) throws Exception{
      	 
    	 Statement select = connection.createStatement();
         ResultSet result = select.executeQuery(
        		 					 			"select "
        		 					 			+ "S.id,S.first_name,S.last_name, S.dob, S.photo_url, "
        		 					 			+ "group_concat(M.id, ',' ,M.title) as movielist "
        		 					 			+ "from stars S "
        		 					 			+ "LEFT JOIN stars_in_movies SM ON S.id = SM.star_id "
        		 					 			+ "LEFT JOIN movies M on SM.movie_id = M.id "
        		 					 			+ "where S.id = "+ SID
        		 					 			+ " group by S.id "
        		 							   );

         ArrayList<String> Records = new ArrayList<String>();
         
         if (!result.next()) {
  	       System.out.println("No record found");
         }
         else{
  	          do
              {
               String resultRecord = result.getString(1)+"~"+result.getString(2)+"~"+
                                     result.getString(3)+"~"+result.getString(4)+"~"+
                                     result.getString(5)+"~"+result.getString(6);                           
               Records.add(resultRecord); 
               resultRecord="";               
              }while (result.next());
             }
         
		return Records; 
     }
       
       public static ArrayList<String> searchMovie(String MID) throws Exception{
        	 
    	 Statement select = connection.createStatement();
         ResultSet result = select.executeQuery(
                 "SELECT "
                + "m.id,"
                + "m.title, "
                + "m.year,"
                + "m.director, "
                + "m.banner_url, "
                + "m.trailer_url, "
                + "group_concat(distinct s.id, ',' ,s.first_name, ' ',s.last_name ),"
                + "group_concat(distinct gs.name separator ',') "
                + "FROM movies m "
                + "LEFT JOIN stars_in_movies sm on sm.movie_id = m.id "
                + "LEFT JOIN stars s ON s.id = sm.star_id "
                + "LEFT JOIN genres_in_movies g ON g.movie_id = sm.movie_id "
                + "LEFT JOIN genres gs ON gs.id = g.genre_id "
                + "WHERE m.id="+MID
                + " group by m.id "		  
        		 );

         ArrayList<String> Records = new ArrayList<String>();
         
         if (!result.next()) {
  	       System.out.println("No record found");
         }
         else{
  	          do
              {
               String resultRecord = result.getString(1)+"~"+result.getString(2)+"~"+
                                     result.getString(3)+"~"+result.getString(4)+"~"+
                                     result.getString(5)+"~"+result.getString(6)+"~"+
                                     result.getString(7)+"~"+result.getString(8);                           
               Records.add(resultRecord); 
               resultRecord="";               
              }while (result.next());
             }
         
		return Records; 
     }
      
    public static ArrayList<String> searchTitle(String searchQuery) throws Exception{

    	Statement select = connection.createStatement();
    	//System.out.println(searchQuery); 
    	String queryString = "SELECT m.title FROM movies m WHERE m.title LIKE '%"+searchQuery+"%'"; 
    	//System.out.println(queryString); 
    	
    	ResultSet result = select.executeQuery(queryString); 
        
    	ArrayList<String> Records = new ArrayList<String>();
         
         if (!result.next()) {
  	       System.out.println("No record found");
         }
         else{
  	          do
              {
               String resultRecord = result.getString(1);                           
               Records.add(resultRecord); 
               resultRecord="";               
              }while (result.next());
             }
         
        return Records;
  }
    
     public static ArrayList<String> searchGenres() throws Exception{
    	 Statement select = connection.createStatement();
         ResultSet result = select.executeQuery
        		 (
        		  "select g.id,"
        		  + "g.name,"
        		  + "group_concat(m.title) "
        		  + "from genres g "
        		  + "LEFT JOIN genres_in_movies gm on gm.genre_id = g.id "
        		  + "LEFT JOIN movies m on m.id = gm.movie_id "
        		  + "group by g.id"
        		 );

         ArrayList<String> Records = new ArrayList<String>();
         
         if (!result.next()) {
  	       System.out.println("No record found");
         }
         else{
  	          do
              {
               String resultRecord = result.getString(1)+"~"+result.getString(2)+"~"+
                                     result.getString(3);                           
               Records.add(resultRecord); 
               resultRecord="";               
              }while (result.next());
             }
         
		return Records; 
    	 
     }
     
     public static ArrayList<String> moviesINGenre(String genre) throws Exception{
    	 Statement select = connection.createStatement();
         ResultSet result = select.executeQuery
        		 (
        		  "select g.id,"
        		  + "g.name,"
        		  + "group_concat(m.title) "
        		  + "from genres g "
        		  + "LEFT JOIN genres_in_movies gm on gm.genre_id = g.id "
        		  + "LEFT JOIN movies m on m.id = gm.movie_id "
        		  + "where g.name='"+genre 
        		  + "' group by g.id"
        		
        		 );

         ArrayList<String> Records = new ArrayList<String>();
         
         if (!result.next()) {
  	       System.out.println("No record found");
         }
         else{
  	          do
              {
               String resultRecord = result.getString(1)+"~"+result.getString(2)+"~"+
                                     result.getString(3);                           
               Records.add(resultRecord); 
               resultRecord="";               
              }while (result.next());
             }
         
		return Records; 
    	 
     } 
     
     public static boolean insertMovie(String email, String passwd, String fname) throws Exception{
    	 
    	 Statement select = connection.createStatement();
         ResultSet result = select.executeQuery
        		 (
        		  "select * "
        		  + " from employees "
        		  + " where email = '"+email
        		  + "' AND password = '"+passwd
        		  + "' AND fullname = '"+fname + "'"
        		 );
         if (!result.next()) {
           return false;
		}
         return true; 
     } 

 public static boolean insertMovies(String title, String year, String direct, 
		 							String burl, String turl, String fname,
		 							String lname, String dob, String purl, String genre) throws Exception{
     String sp = "{call add_movie(?,?,?,?,?,?,?,?,?,?,?)}";

        		 												 
         CallableStatement stmt = null;
         	
         try {
        	 	stmt = connection.prepareCall (sp);
        	 	stmt.setString(1, title);
        	 	stmt.setString(2, year);
        	 	stmt.setString(3, direct);
        	 	stmt.setString(4, burl);
        	 	stmt.setString(5, turl);
        	 	stmt.setString(6, fname);
        	 	stmt.setString(7, lname);
        	 	stmt.setString(8, dob);
        	 	stmt.setString(9, purl);
        	 	stmt.setString(10, genre);
        	    stmt.registerOutParameter(11, java.sql.Types.INTEGER);
        	    
        	    System.out.println("Executing stored procedure..." );
        	    stmt.execute();
        	    
        	    int success = stmt.getInt(11);
        	      System.out.println("xx = "+ success);

         	 }
         catch (SQLException e) {
             e.printStackTrace();
            }
        finally {
           stmt.close();
        }
         return true; 
     } 
 
 public static String MoviesNoStars(){
	 
	 String sp = "{call movies_nostar(?)}";

		 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	     success  = stmt.getString(1);
    	     
     	    if (success==null) success="no result";

    	     stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
	 
 }
 
 public static String StarsNoMovies(){
	 
	 String sp = "{call stars_nomovie(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	     success  = stmt.getString(1);
    	     
       	    if (success==null) success="no result";

    	     stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
	 
 }
 public static String GenresNoMovies(){
	 
	 String sp = "{call genres_nomovie(?)}";
 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	     success  = stmt.getString(1);
    	     
     	     if (success==null) success="no result";
     	    
    	     stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
	 
 }
 public static String MoviesNoGenres(){
	 
	 String sp = "{call movies_nogenre(?)}";
	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	     success  = stmt.getString(1);

    	     if (success==null) success="no result";

    	     stmt.close();
    	     

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
 }
 public static String StarsNoName(){
	 
	 
	 String sp = "{call stars_nofirstlast(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	    success  = stmt.getString(1);
    	    
    	    if (success==null) success="no result";

    	    stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
	 
 }
 public static String ExpiredCC(){
	 
	 
	 String sp = "{call expired_cc(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	    success  = stmt.getString(1);
    	    
    	    if (success==null) success="no result";

    	    stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
 }
 public static String SameMovies(){
	 
 String sp = "{call dup_movies(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	    success  = stmt.getString(1);
    	    
    	    if (success==null) success="no result";

    	    stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
	 
 }
 public static String SameStars(){
	 
 String sp = "{call dup_stars(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	    success  = stmt.getString(1);
    	    
    	    if (success==null) success="no result";

    	    stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
	 
 }
 public static String SameGenres(){
	 
 String sp = "{call dup_genres(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	    success  = stmt.getString(1);
    	    
    	    if (success==null) success="no result";

    	    stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
	 
 }
 public static String DOBError(){
	 
 String sp = "{call dob_greaterless(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	    success  = stmt.getString(1);
    	    
    	    if (success==null) success="no result";

    	    stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success;
 }
 public static String EmailError(){
	 
 String sp = "{call email_error(?)}";

	 
     CallableStatement stmt = null;
     String success = "no result";
     try {
    	 	stmt = connection.prepareCall (sp);
    	 	
    	    stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
    	    
    	    System.out.println("Executing stored procedure..." );
    	    stmt.execute();
    	    
    	    success  = stmt.getString(1);
    	    
    	    if (success==null) success="no result";

    	    stmt.close();

     	 }
     catch (SQLException e) {
         e.printStackTrace();
        }

	 return success; 
   }
 
 public static ArrayList<String> getUsers() throws Exception{
	 Statement select = connection.createStatement();
     ArrayList<String> Records = new ArrayList<String>();

	 ResultSet users_hosts = select.executeQuery
    		 (
    		  "select user,host from mysql.user"
    		 );
	 if (!users_hosts.next()) {
	       System.out.println("No record found");
     }
     else{
	      do
          {
           String user = users_hosts.getString(1);   
           String host = users_hosts.getString(2);   
           select = connection.createStatement();
           ResultSet result = select.executeQuery
          		 (
          		  "show grants for '"
          		  + user
          		  + "'@'"
          		  + host
          		  + "'"
          		 );
         if (!result.next()) {
    	       System.out.println("No record found");
         }
         else{
    	      do
              {
               String resultRecord = result.getString(1);   
               Records.add(resultRecord); 
               resultRecord="";               
              }while (result.next());
             }
           user=""; host="";
          
          }while (users_hosts.next());
     }
     return Records;
 }
 
 public static int addUser(String uname, String host, String pass) throws Exception{
	 Statement select = connection.createStatement();
     int result = select.executeUpdate
						    		 (
						    		   "CREATE USER '"
						    		   + uname
						    		   + "'@'"
						    		   + host
						    		   + "' IDENTIFIED BY '"
						    		   + pass
						    		   + "'"
						    		 );
     return result;
 }
 
 public static void editUser(String command) throws Exception{
	 Statement select = connection.createStatement();
     select.execute(command);
 }
}