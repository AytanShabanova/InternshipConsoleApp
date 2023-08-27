package org.example.operations;

import org.example.models.Student;
import org.example.models.Teacher;
import org.example.service.StudentDbImpl;
import org.example.service.TeacherDbImpl;

import java.util.List;
import java.util.Scanner;

public class StudentDbOperation {
    Scanner sc=new Scanner(System.in);
    StudentDbImpl studentDb=new StudentDbImpl();
    public void StOp(){

            System.out.println("ADD NEW STUDENT 1 \n" +
                    "DELETE STUDENT 2 \n" +
                    "ALL STUDENTS 3");
            int count= sc.nextInt();
            if (count==1){
                System.out.println("ENTER STUDENT NAME");
                String name= sc.next();
                System.out.println("ENTER STUDENT SURNAME");
                String surName= sc.next();
                System.out.println("ENTER TEACHER FINCODE");
                String finCode= sc.next();
                TeacherDbImpl teacherDb=new TeacherDbImpl();
                Teacher teacher=teacherDb.getTeacherByFinCode(finCode);

                studentDb.saveStudent(new Student(null,name,surName,teacher,null));
            } else if (count==2) {
                System.out.println("ENTER STUDENT ID");
                Long id= sc.nextLong();
              studentDb.deleteStudent(id);
            } else if (count==3) {
               List<Student>students= studentDb.getAllStudents();
               students.forEach(student -> System.out.println(student));

            }
        }
    }

