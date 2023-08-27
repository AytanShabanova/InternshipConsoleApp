package org.example;

import jakarta.persistence.EntityManager;
import org.example.config.AbstractDao;
import org.example.models.Student;
import org.example.models.Teacher;
import org.example.operations.TeacherDbOperation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


//        EntityManager entityManager= AbstractDao.em();
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Teacher(null,"hh33","Aytan","Abakarova",1000,null,null));
//        entityManager.getTransaction().commit();
//        entityManager.close();
        TeacherDbOperation teacherDbOperation=new TeacherDbOperation();
        teacherDbOperation.teacherOp();
    }
}