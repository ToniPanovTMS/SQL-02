import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    public static Connection Connect;
    public static Statement statmt;
    public static ResultSet resSer;
    static String[] types = new String[]{"Абиссинская кошка",
            "Австралийский мист",
            "Американская жесткошерстная",
            "Американская короткошерстная",
            "Американский бобтейл",
            "Американский кёрл",
            "Балинезийская кошка",
            "Бенгальская кошка",
            "Бирманская кошка",
            "Бомбейская кошка",
            "Бразильская короткошёрстная",
            "Британская длинношерстная",
            "Британская короткошерстная",
            "Бурманская кошка",
            "Бурмилла кошка",
            "Гавана",
            "Гималайская кошка",
            "Девон-рекс",
            "Донской сфинкс",
            "Европейская короткошерстная",
            "Египетская мау",
            "Канадский сфинкс",
            "Кимрик",
            "Корат",
            "Корниш-рекс",
            "Курильский бобтейл",
            "Лаперм",
            "Манчкин",
            "Мейн-ку́н",
            "Меконгский бобтейл",
            "Мэнкс кошка",
            "Наполеон",
            "Немецкий рекс",
            "Нибелунг",
            "Норвежская лесная кошка",
            "Ориентальная кошка",
            "Оцикет",
            "Персидская кошка",
            "Петерболд",
            "Пиксибоб",
            "Рагамаффин",
            "Русская голубая кошка",
            "Рэгдолл",
            "Саванна",
            "Селкирк-рекс",
            "Сиамская кошка",
            "Сибирская кошка",
            "Сингапурская кошка",
            "Скоттиш-фолд",
            "Сноу-шу",
            "Сомалийская кошка",
            "Тайская кошка",
            "Тойгер",
            "Тонкинская кошка",
            "Турецкая ангорская кошка",
            "Турецкий ван",
            "Украинский левкой",
            "Чаузи",
            "Шартрез",
            "Экзотическая короткошерстная",
            "Японский бобтейл"
    };
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
        }
    }

    public static void get_all_types() throws SQLException {
        statmt = Connect.createStatement();
        ResultSet resultSet = statmt.executeQuery("SELECT * FROM types");
        String Str="";
        while (resultSet.next()) {
            Str=Str+resultSet.getInt("id") + " " + resultSet.getString("type")+"\n";
        }
        JOptionPane.showMessageDialog(null,Str,"Все сроки",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void get_type_where(String where) throws SQLException {
        statmt = Connect.createStatement();
        ResultSet resultSet = statmt.executeQuery("SELECT * FROM types WHERE '"+where+"'");
        String Str="";
        while (resultSet.next()) {
            Str=Str+resultSet.getInt("id") + " " + resultSet.getString("type")+"\n";
        }
        JOptionPane.showMessageDialog(null,Str,"Все сроки",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void get_type(int id) throws SQLException {
        statmt = Connect.createStatement();
        ResultSet resultSet = statmt.executeQuery("SELECT * FROM types WHERE id='"+id+"'");
        String Str=resultSet.getInt("id") + " " + resultSet.getString("type");
        JOptionPane.showMessageDialog(null,Str,"Все сроки",JOptionPane.INFORMATION_MESSAGE);
    }



    public static void Write2DB()  throws SQLException{
        statmt = Connect.createStatement();

        int i=0;
        while(types.length>i){
            try {
                statmt.execute("INSERT INTO types (type) VALUES ('" + types[i] + "')");
            }catch (Exception e){
            }
            i++;
        }
    }

    public static void update_type(int id, String new_type) throws SQLException {
        statmt = Connect.createStatement();
        statmt.execute("UPDATE types SET type ='"+new_type+"' WHERE id = '" + id + "';");
    }
    public static void delete_type(int id) throws SQLException {
        statmt = Connect.createStatement();
        statmt.execute("DELETE FROM types WHERE id = '"+id+"';");
    }


    public static void CloseDB() throws SQLException {
        Connect.close();
        statmt.close();
    }
}
