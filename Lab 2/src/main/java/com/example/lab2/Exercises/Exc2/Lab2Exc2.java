package com.example.lab2.Exercises.Exc2;

public class Lab2Exc2 {

    public static void main(String args [])
    {
        MyOtherClass.b = "my string value";

        MyOtherClass object1 = new MyOtherClass();
        object1.a = 42;

        MyOtherClass object2 = new MyOtherClass();
        object2.a = 23;

        object1.setA(69);
        object1.setB("my other string value");

        System.out.println("Fields of object1:");
        object1.printMyFields();

        System.out.println("Fields of object2:");
        object2.printMyFields();
    }

}

class MyOtherClass
{
    int a;
    static String b;

    void setA(int newA) {
        a = newA;
    }

    void setB(String newB) {
        b = newB;
    }
    void printMyFields()
    {
        System.out.println("Field a is: " + a);
        System.out.println("Field b is: " + b);
    }

}
