package Lab4;

import java.util.Scanner;

public class Student extends Human {

    private String patronymic;
    private double mark;

    public Student()
    {
        super();
        this.patronymic = "";
        this.mark = 0;
    }

    public Student(String name, int age, String sex, String Patronymic, double mark)
    {
        super(name, age, sex);
        this.patronymic = Patronymic;
        this.mark = mark;
    }

    public String GetPatronymic() {return patronymic;}
    public double GetMark() {return mark;}

    public void SetPatronymic(String patronymic) {this.patronymic = patronymic;}
    public void SetMark(double mark) {this.mark = mark;}


    public String toString()
    {
        return super.toString() + "\t" + patronymic + "\t" + mark;
    }

    public Parent CreatePair (Student stud)
    {
        Parent parent = new Parent(stud.GetPatronymic(), stud.GetAge() + 25, "man");
        return parent;
    }

    public Student Add_New_Student()
    {
        Scanner sc = new Scanner(System.in);
        String name, sex, patronymic;
        int age;
        double mark;

        View.out("Введите имя студента");
        name = sc.nextLine();
        View.out("Введите возраст студента");
        age = sc.nextInt();
        sc.nextLine();
        View.out("Введите пол студента");
        sex = sc.nextLine();
        View.out("Введите отчество студента");
        patronymic = sc.nextLine();
        View.out("Введите среднюю оценку студента");
        mark = sc.nextDouble();
        sc.nextLine();

        Student New_Student = new Student(name, age, sex, patronymic, mark);

        return New_Student;
    }
    public String toFileString()
    {
        return super.toFileString() + "\n" + patronymic + "\n" + mark;
    }
}