package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n**** WELCOME TO STUDENT MANAGEMENT SYSTEM ****\n");
        do{
            System.out.println("ENTER 1 -> fOR CREATING STUDENT \n" +
                    "ENTER 2 -> FOR FETCHING ALL THE STUDENTS \n" +
                    "ENTER 3 -> FOR FETCHING STUDENT BY ID \n" +
                    "ENTER 4 -> FOR UPDATE STUDENT BY ID \n" +
                    "ENTER 5 -> FOR DELETING STUDENT BY ID \n" +
                    "ENTER 6 -> FOR EXITING THE PROGRAM");
            System.out.println("---------------------------------------------");
            int n = sc.nextInt();
            System.out.println("---------------------------------------------");
            switch (n){
                case 1 -> {
                    System.out.println("Enter student id :");
                    int id = sc.nextInt();
                    System.out.println("Enter student age :");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter student name");
                    String name = sc.nextLine();
                    StudentInfo student = new StudentInfo(id, age, name);  //creating object of constructor function studentinfo which is present in studentinfo class
                    try{
                        StudentDao.createStudent(student);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                case 2 -> {
                    StudentDao.getAllStudents();
                }
                case 3 -> {
                    System.out.println("Enter id of student which you have to fetch : ");
                    int id = sc.nextInt();
                    StudentDao.getStudentById(id);
                }
                case 4 -> {
                    System.out.println("Enter id of student whose name you want to update : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter updated name : ");
                    String name = sc.nextLine();
                    StudentDao.updateStudentById(id, name);
                }
                case 5 -> {
                    System.out.println("Enter id of student whom you want to delete : ");
                    int id = sc.nextInt();
                    StudentDao.deleteStudentById(id);
                }
                case 6 -> {
                    System.exit(0);
                }
            }
        } while(true);

    }
}