import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;

public class db{
    static int id;
    static String new_type;
    static Scanner scanner= new Scanner(System.in);
public static void main(String[] args)throws ClassNotFoundException, SQLException{
    Connect.Connect();
    Connect.CreateDB();
   // Connect.WriteDB();
    Connect.Write2DB();
    update_type_Info();
    delete_type_Info();
    Connect.CloseDB();
}
static void update_type_Info() throws SQLException {
    id=-1;
    while (id<0)
    try {
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите id поля, которое вы хотите изменить", "Изменение", JOptionPane.QUESTION_MESSAGE));
    }catch (Exception e){
        JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
    }

    new_type=JOptionPane.showInputDialog(null,"Введите значение поля, которое хотите установить","Изменение",JOptionPane.QUESTION_MESSAGE);
    Connect.update_type(id,new_type);
}
    static void delete_type_Info() throws SQLException {
        id=-1;
        while (id<0)
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите id поля, которое вы хотите удалить","Удаление", JOptionPane.QUESTION_MESSAGE));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        Connect.delete_type(id);
    }
}

