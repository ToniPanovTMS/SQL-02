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
            System.out.println("Запись выполнена");
        }
    }

    public static void ReadDB() {
    }

    public static void Write2DB()  throws ClassNotFoundException, SQLException{
        statmt = Connect.createStatement();

        int i=0;
        while(types.length>i){
            try {
                statmt.execute("INSERT INTO types (type) VALUES ('" + types[i] + "')");
            }catch (Exception e){
                System.out.println("Запись выполнена ранее");
            }
            i++;
        }
    }

    public static void CloseDB() throws SQLException {
        Connect.close();
        statmt.close();
    }
}
