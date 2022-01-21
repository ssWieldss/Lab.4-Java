package Lab4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Human {

    private String name;
    private int age;
    private String sex;

    private ArrayList<Human> human_array;
    private LinkedList<Human> human_linked;

    public Human()
    {
        this.name = " ";
        this.age = 0;
        this.sex = "man";

        human_array = new ArrayList<Human>();
        human_linked = new LinkedList<Human>();
    }

    public Human(String name, int age, String sex)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String GetName() {return name;}

    public int GetAge() {return age;}

    public String GetSex() {return sex;}

    public void SetName(String name) {this.name = name;}

    public void SetAge(int age) {this.age = age;}

    public void SetSex(String sex) {this.sex = sex;}

    public String toString()
    {
        return name + "\t" + age + "\t" + sex;
    }

    public String toFileString()
    {
        return name + "\n" + age + "\n" + sex;
    }

    public void Generate_Elements_Arrlist(Human humantemp)
    {
        human_array.add(humantemp);
    }

    public void Remove_Elements_Arrlist(int i)
    {
        human_array.remove(i);
    }

    public void Generate_Elements_Linkedlist(Human linked_temp)
    {
        human_linked.add(linked_temp);
    }

    public void Remove_Elements_Linkedlist(int i)
    {
        human_linked.remove(i);
    }

}
