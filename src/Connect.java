import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    public static Connection Connect;
    public static Statement statmt;
    public static ResultSet resSer;
    public static void Connect() throws ClassNotFoundException, SQLException{
        Connect =null;
        Class.forName("org.sqlite.JDBC");
        Connect=DriverManager.getConnection("jdbc:sqlite:My_cats.db");
    }
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = Connect.createStatement();
        statmt.execute("CREATE TABLE 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,'type' VARCHAR(100) NOT NULL);");
    }
}
