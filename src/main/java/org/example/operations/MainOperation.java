package org.example.operations;

import java.util.Scanner;

public class MainOperation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("ENTER CHOICE \n" +
                "STUDENT OPRETION-1 \n" +
                "TEACHER OPERATION-2\n");
        Integer choice = sc.nextInt();

            if (choice == 1) {
                new StudentDbOperation().StOp();
            } else if (choice == 2) {
                new TeacherDbOperation().teacherOp();
            }else {
                System.exit(1);
            }
        }
    }
}