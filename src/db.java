import java.sql.SQLException;
public class db{
public static void main(String[] args)throws ClassNotFoundException, SQLException{
    Connect.Connect();
    Connect.CreateDB();
    Connect.WriteDB();
    //conn.ReadDB();
    //conn.CloseDB();
}
}

