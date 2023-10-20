import javax.crypto.Cipher;
import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class db{
    static int id;
    static String new_type;
    static String where;
    static String name;
    static String type;
    static int age;
    static double weight;
    static Scanner scanner= new Scanner(System.in);
    public static void main(String[] args)throws ClassNotFoundException, SQLException{
        Connect.Connect();
        Connect.CreateDB();
        Connect.CreateDB_2();
        //Connect.WriteDB();
        //Connect.Write2DB();
        //Connect.add_more_cats(5000);
        //update_type_Info();
        //delete_type_Info();
        //insert_cat_Info();
        //get_type_Info();
        //get_type_where_Info();
        //Connect.get_all_types();
        //delete_cat_id_Info();
        //delete_cat_where_Info();
        //update_cat_id_Info();
        //update_cat_where_Info();
        //Connect.get_all_Cats();
        //get_cats_Info();
        get_cats_where_Info();
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
    static void get_type_Info() throws SQLException {
        id=-1;
        while (id<0)
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите id поля, которое вы хотите Узнать","SELECT", JOptionPane.QUESTION_MESSAGE));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        Connect.get_type(id);
    }
    static void get_type_where_Info() throws SQLException {
        where=null;
        while (where==null)
            try {
                where=JOptionPane.showInputDialog(null,"Введите запрос","SELECT2",JOptionPane.QUESTION_MESSAGE);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        Connect.get_type_where(where);
    }
    static void insert_cat_Info()throws SQLException{
        name=JOptionPane.showInputDialog(null,"Введите имя кошки","Имя",JOptionPane.QUESTION_MESSAGE);
        type=JOptionPane.showInputDialog(null,"Введите пароду кошки","Парода",JOptionPane.QUESTION_MESSAGE);
        age=-1;
        while (age<0){
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите возраст кошки", "Колличество лет", JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Вы ввели не корректные значения");
            }
        }
        weight=-1;
        while (weight<0){
            try {
                weight = Double.parseDouble(JOptionPane.showInputDialog(null,"Введите вес кошки","Изменение",JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Вы ввели не корректные значения");
            }
        }
        Connect.insert_cat(name,type,age,weight);
    }
    static void delete_cat_id_Info() throws SQLException {
        id=-1;
        while (id<0)
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите id поля, которое вы хотите удалить","Удаление2", JOptionPane.QUESTION_MESSAGE));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        Connect.delete_cat_id(id);
    }
    static void delete_cat_where_Info() throws SQLException {
        where=null;
        while (where==null)
            try {
                where=JOptionPane.showInputDialog(null,"Введите запрос","Удаление2",JOptionPane.QUESTION_MESSAGE);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        Connect.delete_cat_where(where);
    }
    static void update_cat_id_Info() throws SQLException{
        id=-1;
        while (id<0) {
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите id Кота, которое вы хотите изменить", "Изменение", JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Вы ввели не корректные значения");
            }
        }
        name=JOptionPane.showInputDialog(null,"Введите имя кошки","Имя",JOptionPane.QUESTION_MESSAGE);
        type=JOptionPane.showInputDialog(null,"Введите пароду кошки","Парода",JOptionPane.QUESTION_MESSAGE);
        age=-1;
        while (age<0){
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите возраст кошки", "Колличество лет", JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Вы ввели не корректные значения");
            }
        }
        weight=-1;
        while (weight<0){
            try {
                weight = Double.parseDouble(JOptionPane.showInputDialog(null,"Введите вес кошки","Изменение",JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Вы ввели не корректные значения");
            }
        }
        Connect.update_cat(id,name+"    "+type+"    "+age+"    "+weight);
    }
    static void update_cat_where_Info() throws SQLException{
        where=null;
        while (where==null)
            try {
                where=JOptionPane.showInputDialog(null,"Введите запрос","изменение по фильтру",JOptionPane.QUESTION_MESSAGE);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        name=JOptionPane.showInputDialog(null,"Введите имя кошки","Имя",JOptionPane.QUESTION_MESSAGE);
        type=JOptionPane.showInputDialog(null,"Введите пароду кошки","Парода",JOptionPane.QUESTION_MESSAGE);
        age=-1;
        while (age<0){
            try {
                age = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите возраст кошки", "Колличество лет", JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Вы ввели не корректные значения");
            }
        }
        weight=-1;
        while (weight<0){
            try {
                weight = Double.parseDouble(JOptionPane.showInputDialog(null,"Введите вес кошки","Изменение",JOptionPane.QUESTION_MESSAGE));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Вы ввели не корректные значения");
            }
        }
        Connect.update_cat(where,name+"    "+type+"    "+age+"    "+weight);
    }
    static void get_cats_Info() throws SQLException {
        id=-1;
        while (id<0)
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите id Котіка, которое вы хотите Узнать","SELECT_CAT_1", JOptionPane.QUESTION_MESSAGE));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        Connect.get_Cats(id);
    }
    static void get_cats_where_Info() throws SQLException {
        where=null;
        while (where==null)
            try {
                where=JOptionPane.showInputDialog(null,"Введите запрос","SELECT_CAT_2",JOptionPane.QUESTION_MESSAGE);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Вы ввели не корректные значения");
            }
        Connect.get_Cats_where(where);
    }

}


