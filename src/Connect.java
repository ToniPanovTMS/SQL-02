import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    public static Connection Connect;
    public static Statement statmt;
    public static ResultSet resSer;
    static String[] types = new String[]{"Абиссинская кошка", "Австралийский мист", "Американская жесткошерстная", "Американская короткошерстная", "Американский бобтейл", "Американский кёрл", "Балинезийская кошка", "Бенгальская кошка", "Бирманская кошка", "Бомбейская кошка", "Бразильская короткошёрстная", "Британская длинношерстная", "Британская короткошерстная", "Бурманская кошка", "Бурмилла кошка", "Гавана", "Гималайская кошка", "Девон-рекс", "Донской сфинкс", "Европейская короткошерстная", "Египетская мау", "Канадский сфинкс", "Кимрик", "Корат", "Корниш-рекс", "Курильский бобтейл", "Лаперм", "Манчкин", "Мейн-ку́н", "Меконгский бобтейл", "Мэнкс кошка", "Наполеон", "Немецкий рекс", "Нибелунг", "Норвежская лесная кошка", "Ориентальная кошка", "Оцикет", "Персидская кошка", "Петерболд", "Пиксибоб", "Рагамаффин", "Русская голубая кошка", "Рэгдолл", "Саванна", "Селкирк-рекс", "Сиамская кошка", "Сибирская кошка", "Сингапурская кошка", "Скоттиш-фолд", "Сноу-шу", "Сомалийская кошка", "Тайская кошка", "Тойгер", "Тонкинская кошка", "Турецкая ангорская кошка", "Турецкий ван", "Украинский левкой", "Чаузи", "Шартрез", "Экзотическая короткошерстная", "Японский бобтейл"};
    static String[] names = {"Гарфилд","Том","Гудвин","Рокки","Ленивец","Пушок","Спорти","Бегемот","Пират","Гудини","Зорро","Саймон","Альбус","Базилио","Леопольд","Нарцисс","Атос","Каспер","Валлито","Оксфорд","Бисквит","Соня","Клеопатра","Цунами","Забияка","Матильда","Кнопка","Масяня","Царапка","Серсея","Ворсинка","Амели","Наоми","Маркиза","Изольда","Вальс","Несквик","Златан","Баскет","Изюм","Цукат","Мокко","Месси","Кокос","Адидас","Бейлиз","Тайгер","Зефир","Мохи","Валенсия","Баунти","Свити","Текила","Ириска","Карамель","Виски","Кукуруза","Гренка","Фасолька","Льдинка","Китана","Офелия","Дайкири","Брусника","Аватар","Космос","Призрак","Изумруд","Плинтус","Яндекс","Крисмас","Метеор","Оптимус","Смайлик","Цельсий","Краска","Дейзи","Пенка","Веста","Астра","Эйприл","Среда","Бусинка","Гайка","Елка","Золушка","Мята","Радость","Сиам","Оскар","Феликс","Гарри","Байрон","Чарли","Симба","Тао","Абу","Ватсон","Енисей","Измир","Кайзер","Васаби","Байкал","Багира","Айрис","Диана","Мими","Сакура","Индия","Тиффани","Скарлетт","Пикси","Лиззи","Алиса","Лило","Ямайка","Пэрис","Мальта","Аляска"};
    public static void Connect() throws ClassNotFoundException, SQLException{
        Connect =null;
        Class.forName("org.sqlite.JDBC");
        Connect=DriverManager.getConnection("jdbc:sqlite:My_cats.db");
    }//Коннект

    public static void CreateDB() throws SQLException{
        statmt = Connect.createStatement();
        try {
            statmt.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, 'type' VARCHAR(100) NOT NULL)");
        }catch (Exception e){
            System.out.println("База существует");
        }

    }//Создание таблицы типов
    public static void CreateDB_2() throws SQLException {
        statmt = Connect.createStatement();
        statmt.execute("CREATE TABLE if not exists cats (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, name VARCHAR(20) NOT NULL, type_id INTEGER NOT NULL, age INTEGER NOT NULL, weight DOUBLE," +
                "FOREIGN KEY(type_id) REFERENCES types (id))");
    }//Создание таблицы котиков
    public static void get_all_types() throws SQLException {
        statmt = Connect.createStatement();
        ResultSet resultSet = statmt.executeQuery("SELECT * FROM types");
        String Str="";
        while (resultSet.next()) {
            Str=Str+resultSet.getInt("id") + " " + resultSet.getString("type")+"\n";
        }
        JOptionPane.showMessageDialog(null,Str,"Все сроки",JOptionPane.INFORMATION_MESSAGE);
    }// получить все типы
    public static void get_type_where(String where) throws SQLException {
        statmt = Connect.createStatement();
        String query = "SELECT * FROM types WHERE " + where;
        ResultSet resultSet = statmt.executeQuery(query);
        String Str="";
        while (resultSet.next()) {
            Str=Str+resultSet.getInt("id") + " " + resultSet.getString("type")+"\n";
        }
        JOptionPane.showMessageDialog(null,Str,"Все сроки",JOptionPane.INFORMATION_MESSAGE);
    }// получить типы по запросу
    public static void get_type(int id) throws SQLException {
        statmt = Connect.createStatement();
        ResultSet resultSet = statmt.executeQuery("SELECT * FROM types WHERE id='"+id+"'");
        String Str=resultSet.getInt("id") + " " + resultSet.getString("type");
        JOptionPane.showMessageDialog(null,Str,"Все сроки",JOptionPane.INFORMATION_MESSAGE);
    }// получить типы по id

    public static void WriteDB()  throws SQLException{
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
    } // заполнение бд
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
    } //массовое заполнение бд

    public static void update_type(int id, String new_type) throws SQLException {
        statmt = Connect.createStatement();
        statmt.execute("UPDATE types SET type ='"+new_type+"' WHERE id = '" + id + "';");
    } // обновить тип
    public static void delete_type(int id) throws SQLException {
        statmt = Connect.createStatement();
        statmt.execute("DELETE FROM types WHERE id = '"+id+"';");
    } //удалить тип
    private static ResultSet getType(String type) throws SQLException {
        Statement statement = Connect.createStatement();
        String query = "SELECT id, type FROM types WHERE " + type;
        return statement.executeQuery(query);
    }// получить результат по типу
    public static void insert_cat(String name, String type, int age, Double weight) {
        try {
            ResultSet resultSet = getType("type = '" + type + "'");
            int id;
            if (resultSet.isBeforeFirst()) //если находится такой тип, то берём его id
                id = resultSet.getInt("id");
            else { //если нет такого типа, то создаём новый и берём
                try {
                    statmt.execute("INSERT INTO types (type) VALUES ('" + type + "')");
                } catch (Exception e) {
                }
                id = getType("type = '" + type + "'").getInt("id");
            }
            Statement statement = Connect.createStatement();
            statement.execute("INSERT INTO 'cats' ('name','type_id','age','weight') " +
                    "VALUES ('" + name + "'," + id + "," + age + "," + weight + ")");
        } catch (Exception e) {
        }
    }//заполнение бд добавить кота
    public static void add_more_cats(int n) throws SQLException {
        while(n>1){
            Statement statement = Connect.createStatement();
            statement.execute("INSERT INTO 'cats' ('name','type_id','age','weight') " +
                    "VALUES ('" + Ramdom_Name_Cat() + "'," + Ramdom_Type_id_Cat() + "," + Ramdom_Age_Cat() + "," + Ramdom_Weight_Cat() + ")");
            n--;
        }
    }// заполнение бд раномными котами
    public static String Ramdom_Name_Cat() {
        int name_random_namber_a = 0;
        int name_random_namber_b = 118;
        int random_number_Name = name_random_namber_a + (int) (Math.random() * name_random_namber_b);
        int name_random_namber= random_number_Name;
        return names[random_number_Name];
    }//генерация имени кота
    public static int Ramdom_Type_id_Cat(){
        int Type_random_namber_a = 1;
        int Type_random_namber_b = 61;
        int random_number_Type = Type_random_namber_a + (int) (Math.random() * Type_random_namber_b);
        return random_number_Type;
    }//генерация типа кота
    public static int Ramdom_Age_Cat() {
        int Type_random_namber_a = 0;
        int Type_random_namber_b = 20;
        int random_number_Type = Type_random_namber_a + (int) (Math.random() * Type_random_namber_b);
        return random_number_Type;
    }//генерация возраста кота
    public static double Ramdom_Weight_Cat() {
        double Type_random_namber_a = 0;
        double Type_random_namber_b = 15;
        BigDecimal bd = new BigDecimal(Type_random_namber_a +(Math.random() * Type_random_namber_b));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        double random_number_Type = bd.doubleValue();;
        return random_number_Type;
    }//генерация веса кота
    public static void delete_cat_id(int id) throws SQLException {//удаление котика по id
        statmt = Connect.createStatement();
        statmt.execute("DELETE FROM cats WHERE id = '"+id+"';");
    }
    public static void delete_cat_where(String where) throws SQLException {//удаление котика по условию
        statmt = Connect.createStatement();
        statmt.execute("DELETE FROM cats WHERE "+where+";");
    }

    public static void update_cat(int id, String set) throws SQLException {//изменение котика по id
        String[] words = set.split("    ");
        statmt = Connect.createStatement();
        try {
            ResultSet resultSet = getType("type = '" + words[1] + "'");
            int id_type;
            if (resultSet.isBeforeFirst()) //если находится такой тип, то берём его id
                id_type = resultSet.getInt("id");
            else { //если нет такого типа, то создаём новый и берём
                try {
                    statmt.execute("INSERT INTO types (type) VALUES ('" + words[1] + "')");
                } catch (Exception e) {
                }
                id_type = getType("type = '" + words[1] + "'").getInt("id");
            }
            Statement statement = Connect.createStatement();
            statement.execute("UPDATE 'cats' SET name='" + words[0] + "',type_id=" + id_type + ",age=" + words[2] + ",weight=" + words[3] + " WHERE id ='" + id + "';");
        } catch (Exception e) {
        }
    }
    public static void update_cat(String where,String set) throws SQLException { //изменение котика по условию
        String[] words = set.split("    ");
        statmt = Connect.createStatement();
        try {
            ResultSet resultSet = getType("type = '" + words[1] + "'");
            int id_type;
            if (resultSet.isBeforeFirst()) //если находится такой тип, то берём его id
                id_type = resultSet.getInt("id");
            else { //если нет такого типа, то создаём новый и берём
                try {
                    statmt.execute("INSERT INTO types (type) VALUES ('" + words[1] + "')");
                } catch (Exception e) {
                }
                id_type = getType("type = '" + words[1] + "'").getInt("id");
            }
            Statement statement = Connect.createStatement();
            statement.execute("UPDATE 'cats' SET name='" + words[0] + "',type_id=" + id_type + ",age=" + words[2] + ",weight=" + words[3] + " WHERE " + where+";");
        } catch (Exception e) {
        }
    }






    public static void CloseDB() throws SQLException {
        Connect.close();
        statmt.close();
    } // отключаемся от бд
}