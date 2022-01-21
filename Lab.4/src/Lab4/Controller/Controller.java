package Lab4.Controller;

import Lab4.Human;
import Lab4.Model;
import Lab4.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Controller {

    private static String USER = "";
    private static String PASSWORD = "";
    private static boolean ROOT = false;
    private static boolean DEBUG = false;
    private static boolean TEST = false;
    private static String LOG_FILE = "";


    public static void Start() throws IOException {
        Properties props = new Properties();
        String path = new String(new File("C:\\Users\\egor1\\IdeaProjects\\Lab.4\\src\\config\\properties.ini").getAbsolutePath().getBytes("WINDOWS-1251"));
        props.load(new FileInputStream(new File(path)));
        USER = props.getProperty("USER");
        PASSWORD = props.getProperty("PASSWORD");
        ROOT = Boolean.parseBoolean(props.getProperty("ROOT"));
        DEBUG = Boolean.parseBoolean(props.getProperty("DEBUG"));
        TEST = Boolean.parseBoolean(props.getProperty("TEST"));
        LOG_FILE = props.getProperty("LOG_FILE");
    }


    public static void Enter(My_Logger my_logger) {

        my_logger.add_Log(Level.WARNING, "Запуск программы");

        String log_pass = View.Input_Start_Data();

        while (!(USER + " " + PASSWORD).equals(log_pass)) {

            View.out("Ошибка входа! Проверьте правильность набранных данных");

            if (DEBUG)
                my_logger.add_Log(Level.WARNING, "Попытка входа в аккаунт " + USER);

            log_pass = View.Input_Start_Data();
        }
    }


    public static void Process() {

        ArrayList<ArrayList> Base = new ArrayList<>(4);
        Base = Model.Create_Null_Base(Base);

        //Reading for configuration file

        try {
            Start();
        }
        catch (IOException ex) {
            View.out("Не удалось загрузить файл конфигурации");
        }

        My_Logger my_logger;

        try {
            my_logger = new My_Logger(LOG_FILE);
        }
        catch (IOException e) {
            View.out("Не удалось загрузить файл настроек логера");
            return;
        }

        //Enter into the account

        Enter(my_logger);

        if (DEBUG)
            my_logger.add_Log(Level.INFO, "Выполнен вход в аккаунт " + USER);
        if (ROOT && TEST) {

            if (ROOT && TEST) {

                Human human = new Human();

                View.out("Тестирование создания ArrayList");

                my_logger.add_Log(Level.INFO, "Testing ArrayList");

                for (int j = 0; j < 5; j++) {

                    long allTime = 0;
                    my_logger.add_Log(Level.INFO, "Тестирование создания ArrayList " + Math.pow(10, j + 1));

                    for (int i = 0; i < Math.pow(10, j + 1); i++) {

                        Human human_temp = new Human("Егор", 19, "man");

                        long currentStart = System.nanoTime();
                        human.Generate_Elements_Arrlist(human_temp);
                        long currentEnd = System.nanoTime();
                        long oneTime = currentEnd - currentStart;
                        allTime += oneTime;
                       // my_logger.add_Log(Level.INFO, "добавлен, ID = " + i + ", " + oneTime);
                    }

                    String text = "Процесс заполнения ArrayList, состоящий из " + Math.pow(10, j + 1) + " занял " +
                            (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1);
                    View.out(text);
                    my_logger.add_Log(Level.INFO, text);

                    allTime = 0;


                    for (int i = 0; i < Math.pow(10, j + 1)/10; i++) {
                        long currentStart = System.nanoTime();
                        human.Remove_Elements_Arrlist(i);
                        long currentEnd = System.nanoTime();
                        long oneTime = currentEnd - currentStart;
                        allTime += oneTime;
                        //my_logger.add_Log(Level.INFO, "удаление, ID = " + i + ", " + oneTime);
                    }

                    text = "Процесс удаления из ArrayList " + Math.pow(10, j + 1) / 10 + " элементов занял " +
                            (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1) / 10;
                    View.out(text);
                    my_logger.add_Log(Level.INFO, text);
                }

                View.out("Тестирование создания LinkedList");

                my_logger.add_Log(Level.INFO, "Testing LinkedList");

                for (int j = 0; j < 5; j++) {

                    long allTime = 0;

                    my_logger.add_Log(Level.INFO, "Тестирование создания LinkedList " + Math.pow(10, j + 1));


                    for (int i = 0; i < Math.pow(10, j + 1); i++) {

                        Human human_temp = new Human("Егор", 19, "man");

                        long currentStart = System.nanoTime();
                        human.Generate_Elements_Linkedlist(human_temp);
                        long currentEnd = System.nanoTime();
                        long oneTime = currentEnd - currentStart;
                        allTime += oneTime;
                        //my_logger.add_Log(Level.INFO, "Добавление, ID = " + i + ", " + oneTime);
                    }

                    String text = "Процесс заполнения LinkedList, состоящий из " + Math.pow(10, j + 1) + " занял " +
                            (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1);
                    View.out(text);
                    my_logger.add_Log(Level.INFO, text);

                    for (int i = 0; i < Math.pow(10, j + 1)/10; i++) {
                        long currentStart = System.nanoTime();
                        human.Remove_Elements_Linkedlist(i);
                        long currentEnd = System.nanoTime();
                        long oneTime = currentEnd - currentStart;
                        allTime += oneTime;
                        //my_logger.add_Log(Level.INFO, "remove, ID = " + i + ", " + oneTime);
                    }

                    text = "Процесс удаления из LinkedList " + Math.pow(10, j + 1) / 10 + " элементов занял " +
                            (allTime) + ". Среднее время: " + (allTime) / Math.pow(10, j + 1) / 10;
                    View.out(text);
                    my_logger.add_Log(Level.INFO, text);
                }
            }

        } else if (ROOT) {
            View.out("Здравствуйте, Хозяин!");
        } else {
            View.out("Добро пожаловать " + USER);
        }

        int n = 0;

        do {
            View.Menu_Out();
            n = View.Number();

            switch (n) {
                case 1 -> {
                    try {
                        Base = Model.ReadFile();
                        View.out("Файл успешно загружен");

                        if (DEBUG)
                            my_logger.add_Log(Level.INFO, "Файл успешно загружен");
                    } catch (IOException ex) {
                        View.out("Возникли ошибки при чтении файла");
                        if (DEBUG)
                            my_logger.add_Err(ex);
                    }
                    catch (NoSuchElementException e) {
                        View.out("В файле нет элементов!");
                        if (DEBUG)
                            my_logger.add_Err(e);
                    }
                }
                case 2 -> {
                    try {
                        String TextFile;
                        TextFile = Model.ToFile(Base.get(0), Base.get(1), Base.get(2), Base.get(3));

                        boolean res = Model.SaveFile("C:\\Users\\egor1\\IdeaProjects" +
                                "\\Lab.4\\src\\files\\Base.txt", TextFile);

                        if (res) {
                            View.out("Файл успешно сохранен");
                            if (DEBUG)
                                my_logger.add_Log(Level.INFO, "Файл успешно сохранен");
                        }
                    } catch (IOException ex) {
                        View.out("Возникли ошибки при сохранении");
                        if (DEBUG)
                            my_logger.add_Err(ex);
                    }
                }

                case 3 -> View.Print_Base(Base);

                case 4 -> {

                    int number;
                    number = View.Menu_Add();
                    Base = Model.Add_New_Element(Base, number);

                    if (DEBUG)
                        my_logger.add_Log(Level.INFO, "В базу был добавлен новый элемент");

                }

                case 5 -> {

                    int number;
                    number = View.Menu_Delete();
                    Base = Model.Delete_Element(Base, number);
                    if (DEBUG)
                        my_logger.add_Log(Level.INFO, "Из базы был удален элемент");
                }
            }

        }
        while (n != 6);
    }
}
