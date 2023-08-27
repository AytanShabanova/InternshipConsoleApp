package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.AbstractDao;
import org.example.models.Teacher;

import java.util.List;

public class TeacherDbImpl extends AbstractDao {
   public void saveTeacher(Teacher teacher){
       EntityManager entityManager=em();
       entityManager.getTransaction().begin();
       entityManager.persist(teacher);
       entityManager.getTransaction().commit();
       entityManager.close();

   }
   public Teacher getTeacherByFinCode(String finCode){
       EntityManager entityManager=em();
       entityManager.getTransaction().begin();
     TypedQuery<Teacher>typedQuery= entityManager.createQuery("select t  from Teacher  t where  t.finCode=?1", Teacher.class);
     typedQuery.setParameter(1,finCode);
     Teacher teacher=typedQuery.getSingleResult();
     entityManager.getTransaction().commit();
     entityManager.close();
     return  teacher;
   }
   public List<Teacher>getAllTeacher(){
       EntityManager entityManager=em();
       entityManager.getTransaction().begin();
      TypedQuery<Teacher>typedQuery= entityManager.createQuery("select t from Teacher t ", Teacher.class);
       List<Teacher>teachers=typedQuery.getResultList();
       entityManager.getTransaction().commit();
       entityManager.close();
       return teachers;
   }
   public void deleteTeacher(String finCode){
       EntityManager entityManager=em();
       entityManager.getTransaction().begin();
       Teacher teacher=getTeacherByFinCode(finCode);

       entityManager.remove(entityManager.merge(teacher));
       entityManager.getTransaction().commit();
          entityManager.close();

   }
   public void updateWithSalary(String finCode,Integer salary){
       EntityManager entityManager=em();
       entityManager.getTransaction().begin();
       Teacher teacher=getTeacherByFinCode(finCode);
       teacher.setSalary(salary);
       entityManager.merge(teacher);
       entityManager.getTransaction().commit();
       entityManager.close();

   }
}
