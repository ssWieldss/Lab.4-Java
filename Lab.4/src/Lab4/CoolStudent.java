package Lab4;

import java.util.Scanner;

public class CoolStudent extends Human {
    private String patronymic;
    private double mark;

    public CoolStudent()
    {
        super();
        this.patronymic = "";
        this.mark = 0;
    }

    public CoolStudent(String name, int age, String sex, String Patronymic, double mark)
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

    public CoolParent CreatePair (CoolStudent coolstud)
    {
        CoolParent coolparent = new CoolParent(coolstud.GetPatronymic(),
                coolstud.GetAge() + 25, "man", Math.pow(10, coolstud.GetMark()));
        return coolparent;
    }

    public CoolStudent Add_New_CoolStudent()
    {
        Scanner sc = new Scanner(System.in);
        String name, sex, patronymic;
        int age;
        double mark;

        View.out("Введите имя крутого студента");
        name = sc.nextLine();
        View.out("Введите возраст крутого студента");
        age = sc.nextInt();
        sc.nextLine();
        View.out("Введите пол крутого студента");
        sex = sc.nextLine();
        View.out("Введите отчество крутого студента");
        patronymic = sc.nextLine();
        View.out("Введите среднюю оценку крутого студента");
        mark = sc.nextDouble();
        sc.nextLine();


        CoolStudent New_CoolStudent = new CoolStudent(name, age, sex, patronymic, mark);
        return New_CoolStudent;
    }

    public String toFileString()
    {
        return super.toFileString() + "\n" + patronymic + "\n" + mark;
    }
}

