package org.example.operations;

import org.example.models.Teacher;
import org.example.service.TeacherDbImpl;

import java.util.List;
import java.util.Scanner;

public class TeacherDbOperation {
     Scanner sc=new Scanner(System.in);
     TeacherDbImpl teacherDb=new TeacherDbImpl();

     public void teacherOp(){

             System.out.println(" ADD TEACHER 1 \n" +
                     "GET TEACHER BY FINCODE 2 \n" +
                     "DELETE TEACHER 3 \n" +
                     "ALL TEACHERS 4\n" +
                     "UPDATE TEACHER SALARY");
             int count= sc.nextInt();
             if (count==1){
                 System.out.println("ENTER TEACHER FINCODE");
                 String finCode= sc.next();
                 System.out.println("ENTER TEACHER NAME");
                 String name= sc.next();
                 System.out.println("ENTER TEACHER SURNAME");
                 String surName= sc.next();
                 System.out.println("ENTER TEACHER SALARY");
                 int salary=sc.nextInt();
                 Teacher teacher=new Teacher(null,finCode,name,surName,salary,null,null);
                 teacherDb.saveTeacher(teacher);

             } else if (count==2) {
                 System.out.println("ENTER TEACHER FINCODE");
                 String finCode= sc.next();
               Teacher teacher=  teacherDb.getTeacherByFinCode(finCode);
                 System.out.println(teacher);


             } else if (count==3) {
                 System.out.println("ENTER TEACHER FINCODE");
                 String finCode= sc.next();
                 teacherDb.deleteTeacher(finCode);

             } else if (count==4) {

                List<Teacher>teachers= teacherDb.getAllTeacher();
                 teachers.stream().forEach(teacher -> System.out.println(teacher));
             } else if (count==5) {
                 System.out.println("ENTER TEACHER FINCODE");
                 String finCode= sc.next();
                 System.out.println("ENTER NEW SALARY");
                 Integer salary= sc.nextInt();
                 teacherDb.updateWithSalary(finCode,salary);


             } else {
                 System.exit(1);
             }
         }
     }

