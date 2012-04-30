/**
 * 
 */
package g5.ambience.util;

/**
 * @author Nick
 *
 */

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.security.MessageDigest;

public class Auth 
{
	private boolean allowed;
	private static String username;
	private static String password;
	private static String hash;
	private static String query_hash;
	
	public Auth() 
	{
		allowed = false;
	}
	
	
	
	/* === AUTH RUN ===
	 * Calls all appropriate functions in sequence to handle 
	 * authentication
	 */
	public static void run_auth(String pass)
	{
		password = pass;
		
		// Call hash function to encrypt the input password
		try 
		{
			hash = hash_password(password);
			System.out.println("Hashed password: " + hash);
		} 
		catch (Exception e) 
		{
			System.out.println("There was an error hashing the input password...");
			e.printStackTrace();
		}
		
		// Call query function to retrieve hash from the DB
		try 
		{
			query_hash = query_hash();
			System.out.println("Queried hash: " + query_hash);
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("There was an error querying the database...");
			e.printStackTrace();
		}
	}
	
	
	/* === HASH PASSWORD ===
	 * Turns a password into a 32-character string hash
	 */
	public static String hash_password(String password) throws Exception
	{
		// Digest the password with MD5 algorithm
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		 
		byte byte_data[] = md.digest();
		 
		//convert the bytes to hex format 
		StringBuffer sb = new StringBuffer();
		        
		for (int i = 0; i < byte_data.length; i++) 
		{
			sb.append(Integer.toString((byte_data[i] & 0xff) + 0x100, 16).substring(1));
		}
		 
		//System.out.println("Hashed password: " + sb.toString());
		return sb.toString();
	}// END HASH_PASSWORD()
	
	
	
	/* === QUERY HASH ===
	 * Queries the database to retrieve the stored password hash and returns it as a string
	 */
	@SuppressWarnings("finally")
	private static String query_hash() throws ClassNotFoundException
	{
		Connection conn; // Initialize connection variable
		CallableStatement cs;  // Callable statement to be used for query
		
		// Query the database for the stored hash
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} 
		catch (InstantiationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Try connecting to database
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ambience", "root", "buster");
			
			// This prepares the stored procedure call by providing the procedure name and
			// number of parameters involved.  (IN, OUT).
			cs = conn.prepareCall("{CALL get_password_hash(?,?)}");
			
			// Registers the out parameter, 1 = in, 2 = out, the procedure returns type char(32)
			cs.registerOutParameter(2, Types.CHAR);
			
			// Prepares the string to be passed through 1 = IN as a string.  User name will be passed
			cs.setString(1, username);
			
			// Executes the query with above parameters
			cs.execute();
			
			// Converts the output from the query to a string
			query_hash = cs.getString(2);
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Failed to connect to database...");
			e.printStackTrace();
			
		}
		
		// Return result of query from database
		return query_hash;
	}// END QUERY_HASH()
	
	
	
	/* === IS ALLOWED ===
	 *Returns true/false for if a user is allowed or not allowed to log in based on their 
     *login credentials during a session.
     */
	public boolean is_allowed()
	{
		boolean allowed;
		
		// Compare hashes to see if they match
		if (hash.equals(query_hash))
		{
			System.out.println("Match successful!");
			allowed = true;
		}
		else
		{
			System.out.println("Invalid credentials...");
			allowed = false;
		}
		
		//if (fail_count >= 3)
			//allowed = false;
		
		return allowed;
	}// END IS_ALLOWED()
	
}// END CLASS