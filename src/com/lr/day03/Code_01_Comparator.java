package com.lr.day03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ALTERUI on 2019/1/31 15:35
 */
public class Code_01_Comparator {
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    /**
     * 自定义的比较器类
     */
    public static class IdAsCeilComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            //正序
            return o1.id - o2.id;
        }
    }

    //自定义打印Student
    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name:" + student.name + ", id:" + student.id + ", age:" + student.age);
        }

        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        System.out.println("排序前：");
        Student[] students = new Student[]{student3, student2, student1};
        printStudents(students);

        System.out.println("按照id排序后：");
        Arrays.sort(students,new IdAsCeilComparator());
        printStudents(students);
    }
}
