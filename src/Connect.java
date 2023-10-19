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
        try {
            statmt.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, 'type' VARCHAR(100) UNIQUE NOT NULL)");
        }catch (Exception e){
            System.out.println("База существует");
        }


    }

    public static void WriteDB()  throws ClassNotFoundException, SQLException{
        statmt = Connect.createStatement();
        String[] str = new String[]{"Абиссинская кошка","Австралийский мист","Американская жесткошерстная"};
        try {
            statmt.execute("INSERT INTO types (type) VALUES ('" + str[0] + "')");
        }catch (Exception e){
            System.out.println("Запись выполнена");
        }
        try {
            statmt.execute("INSERT INTO types (type) VALUES ('" + str[1] + "')");
        }catch (Exception e){
            System.out.println("Запись выполнена");
        }try {
            statmt.execute( "INSERT INTO types (type) VALUES ('" + str[2] + "')");
        }catch (Exception e){
            System.out.println("Запись выполнена");
        }
    }

    public static void ReadDB() {
    }

    public static void CloseDB() throws SQLException {
        Connect.close();
        statmt.close();
    }
}
