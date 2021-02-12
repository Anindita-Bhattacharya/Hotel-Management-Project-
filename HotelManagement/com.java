//Java Database Connectivity with 5 steps
//1.Register the driver class
//2.Create the connection object
//3.Create the Statement object
//4.Execute the query
//5.Close the connection object
import java.sql.*;
public class com 
{
	Connection c;
	Statement s;
	public com()
	{
		//whenever we are working with some external files it is a good practise to write try catch block
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql:///hms","root","root");
			s=c.createStatement();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
