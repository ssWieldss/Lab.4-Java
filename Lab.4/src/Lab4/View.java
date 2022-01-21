package Lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

    public static void out(String key) {
        System.out.println(key);}

    public static void Menu_Out()
    {
        View.out("-----------------------------------------");
        View.out("Выберите Действие:");
        View.out(".........................................");
        View.out("Считать данные из файла:................1");
        View.out("Записать данные в файл..................2");
        View.out("Вывод имеющихся данных..................3");
        View.out("Добавить данные.........................4");
        View.out("Удалить данные..........................5");
        View.out("Выход из программы......................6");
    }

    public static int Menu_Add()
    {
        int number;

        View.out("Выберите, кого вы хотите создать:");
        View.out("Родитель..............1");
        View.out("Студент...............2");
        View.out("Крутой Студент........3");
        View.out("Крутой Родитель.......4");

        number = View.Number();
        return number;
    }

    public static int Menu_Delete()
    {
        int number;

        View.out("Выберите, кого вы хотите удалить:");
        View.out("Родитель..............1");
        View.out("Студент...............2");
        View.out("Крутой Студент........3");
        View.out("Крутой Родитель.......4");

        number = View.Number();
        return number;
    }

    /*public static int Menu_Change()
    {
        int number;

        View.out("Выберите, кого вы хотите изменить:");
        View.out("Родитель..............1");
        View.out("Студент...............2");
        View.out("Крутой Студент........3");
        View.out("Крутой Родитель.......4");

        number = View.Number();
        return number;
    }*/

    public static String Input_Start_Data()
    {
        Scanner sn = new Scanner(System.in);
        View.out("Введите логин");
        String login = sn.next();
        View.out("Введите пароль");
        String password = sn.next();
        return login + " " + password;
    }

    public static int Number()
    {
        Scanner sn = new Scanner(System.in);
        String str;
        int n;
        while (true)
        {
            str = sn.next();
            try
            {
                n = Integer.parseInt(str);
                break;
            }
            catch (NumberFormatException ex)
            {
                View.out("Неккорректный ввод! Требуется целое число");
            }
        }
        return n;
    }

    public static void Print_Base(ArrayList<ArrayList> Base)
    {
        View.out("Родители: ");
        for(int i = 0; i < Base.get(0).size(); i++)
        {
            View.out(Base.get(0).get(i).toString());
        }

        View.out("Студенты: ");
        for(int i = 0; i < Base.get(1).size(); i++)
        {
            View.out(Base.get(1).get(i).toString());
        }

        View.out("Крутые студенты: ");
        for(int i = 0; i < Base.get(2).size(); i++)
        {
            View.out(Base.get(2).get(i).toString());
        }

        View.out("Крутые родители: ");
        for(int i = 0; i < Base.get(3).size(); i++)
        {
            View.out(Base.get(3).get(i).toString());
        }
    }

}

