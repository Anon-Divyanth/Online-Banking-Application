package test;
import java.sql.Connection;
import java.sql.DriverManager;
public class Database{
	private static Connection con = null;
	private Database() {}
	static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "divyanth", "tammu");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }
	public static Connection getCon() {
		return con;
		
	}
}
