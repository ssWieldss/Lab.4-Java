package Lab4;

import java.util.Scanner;

public class Parent extends Human {

    public Parent()
    {
        super();
    }

    public Parent(String name, int age, String sex)
    {
        super(name, age, sex);
    }

    public String toString()
    {
        return super.toString();
    }

    public Student CreatePair (Parent parent)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = sc.nextLine();
        System.out.println("Введите пол студента");
        String sex = sc.nextLine();

        System.out.println("Введите среднюю оценку студента");
        double mark = sc.nextDouble();

        Student stud = new Student(name, parent.GetAge() - 25, sex, parent.GetName(), mark);
        return stud;
    }

    public Parent Add_New_Parent()
    {
        Scanner sc = new Scanner(System.in);
        String name, sex;
        int age;

        View.out("Создайте родителя");
        View.out("Введите имя родителя");
        name = sc.nextLine();
        View.out("Введите возраст родителя");
        age = sc.nextInt();
        sc.nextLine();
        View.out("Введите пол родителя");
        sex = sc.nextLine();

        Parent New_Parent;
        New_Parent = new Parent(name, age, sex);
        return New_Parent;
    }

}