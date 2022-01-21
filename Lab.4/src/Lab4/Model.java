package Lab4;

import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Model
{

    public static ArrayList ReadFile() throws java.io.IOException, NoSuchElementException
    {
                ArrayList<ArrayList> Base = new ArrayList<ArrayList>(4);

        ArrayList<Parent> BaseParent = new ArrayList<Parent>(1);
        ArrayList<Student> BaseStudent = new ArrayList<Student>(1);
        ArrayList<CoolStudent> BaseCoolStudent = new ArrayList<CoolStudent>(1);
        ArrayList<CoolParent> BaseCoolParent = new ArrayList<CoolParent>(1);

        File BaseFile = new File("C:\\Users\\egor1\\IdeaProjects\\Lab.4\\src\\files\\Base.txt");
        Scanner scanner;

        String control_str = "";

        try {
            scanner = new Scanner(BaseFile);
            int number_elements = scanner.nextInt();
            int number_countains = 0;

            for (int j = 0; j < number_elements; j++) {
                number_countains = scanner.nextInt();
                control_str = scanner.next();

                if (control_str.equals("P")) {
                    for (int i = 0; i < number_countains; i++) {
                        String name = scanner.next();
                        int age = scanner.nextInt();
                        String sex = scanner.next();
                        Parent parent = new Parent(name, age, sex);
                        BaseParent.add(parent);
                    }
                } else if (control_str.equals("S")) {
                    for (int i = 0; i < number_countains; i++) {
                        String name = scanner.next();
                        int age = scanner.nextInt();
                        String sex = scanner.next();
                        String patronymic = scanner.next();
                        double mark = scanner.nextDouble();
                        Student Student = new Student(name, age, sex, patronymic, mark);
                        BaseStudent.add(Student);
                    }

                } else if (control_str.equals("CS")) {

                    for (int i = 0; i < number_countains; i++) {
                        scanner.useLocale(Locale.US);
                        String name = scanner.next();
                        int age = scanner.nextInt();
                        String sex = scanner.next();
                        String patronymic = scanner.next();
                        double mark = scanner.nextDouble();
                        CoolStudent CoolStudent = new CoolStudent(name, age, sex, patronymic, mark);
                        BaseCoolStudent.add(CoolStudent);
                    }
                } else if (control_str.equals("CP")) {

                    for (int i = 0; i < number_countains; i++) {
                        scanner.useLocale(Locale.US);
                        String name = scanner.next();
                        int age = scanner.nextInt();
                        String sex = scanner.next();
                        double pocketmoney = scanner.nextDouble();
                        CoolParent CoolParent = new CoolParent(name, age, sex, pocketmoney);
                        BaseCoolParent.add(CoolParent);
                    }
                }

            }
        }
        catch (FileNotFoundException e) {
            View.out("Файл не найден!");
        }

        Base.add(BaseParent);
        Base.add(BaseStudent);
        Base.add(BaseCoolStudent);
        Base.add(BaseCoolParent);

        return Base;
    }

    public static String ToFile(ArrayList <Parent> BaseParent, ArrayList <Student> BaseStudent,
                                ArrayList <CoolStudent> BaseCoolStudent, ArrayList <CoolParent> BaseCoolParent)
    {
        String TextToFile = "";
        TextToFile += BaseParent.size() + BaseStudent.size() + BaseCoolStudent.size() + BaseCoolParent.size() + "\n";

        TextToFile += Integer.toString(BaseParent.size()) + "\n";
        TextToFile += "P" + "\n";

        for(int i = 0; i< BaseParent.size(); i++) {
            TextToFile += BaseParent.get(i).toFileString() + "\n";
        }

        TextToFile += Integer.toString(BaseStudent.size()) + "\n";
        TextToFile += "S" + "\n";

        for(int i = 0; i< BaseStudent.size(); i++) {
            TextToFile += BaseStudent.get(i).toFileString() + "\n";
        }

        TextToFile += Integer.toString(BaseCoolStudent.size()) + "\n";
        TextToFile += "CS" + "\n";

        for(int i = 0; i< BaseCoolStudent.size(); i++) {
            TextToFile += BaseCoolStudent.get(i).toFileString() + "\n";
        }

        TextToFile += Integer.toString(BaseCoolParent.size()) + "\n";
        TextToFile += "CP" + "\n";

        for(int i = 0; i< BaseCoolParent.size(); i++) {
            TextToFile += BaseCoolParent.get(i).toFileString() + "\n";
        }

        return TextToFile;
    }

    public static boolean SaveFile(String FileName, String TextFile) throws java.io.IOException
    {
        boolean Result = false;
//        FileWriter writer = null;
        try(FileWriter writer = new FileWriter(FileName, false)){
            writer.write(TextFile);
            Result = true;
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        return Result;
    }

    public static ArrayList Add_New_Element(ArrayList <ArrayList> Base, int number)
    {
        if( number == 1)
        {
            Parent parent = new Parent();
            parent = parent.Add_New_Parent();
            Base.get(number - 1).add(parent);
        }
        else if(number == 2)
        {
            Student student = new Student();
            student = student.Add_New_Student();
            Base.get(number - 1).add(student);
        }
        else if(number== 3)
        {
            CoolStudent coolstudent = new CoolStudent();
            coolstudent = coolstudent.Add_New_CoolStudent();
            Base.get(number - 1).add(coolstudent);
        }
        else if(number== 4)
        {
            CoolParent coolparent = new CoolParent();
            coolparent = coolparent.Add_New_CoolParent();
            Base.get(number - 1).add(coolparent);
        }

        return Base;
    }

    public static ArrayList Delete_Element(ArrayList <ArrayList> Base, int number)
    {
        View.out("Кого вы хотите удалить?");

        for(int i = 0; i < Base.get(number-1).size(); i ++)
        {
            View.out((i+1)+". " + Base.get(number-1).get(i).toString());
        }

        Scanner sc = new Scanner(System.in);
        int choose;
        choose = sc.nextInt();
        Base.get(number-1).remove(choose-1);


        return Base;
    }

    public static ArrayList Create_Null_Base(ArrayList <ArrayList> Base)
    {
        ArrayList<Parent> BaseParent = new ArrayList<Parent>(1);
        ArrayList<Student> BaseStudent = new ArrayList<Student>(1);
        ArrayList<CoolStudent> BaseCoolStudent = new ArrayList<CoolStudent>(1);
        ArrayList<CoolParent> BaseCoolParent = new ArrayList<CoolParent>(1);

        Base.add(BaseParent);
        Base.add(BaseStudent);
        Base.add(BaseCoolStudent);
        Base.add(BaseCoolParent);

        return Base;
    }
}
