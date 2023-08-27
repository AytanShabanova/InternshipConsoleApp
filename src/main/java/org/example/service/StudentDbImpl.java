package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.AbstractDao;
import org.example.models.Student;


import java.util.List;

public class StudentDbImpl extends AbstractDao {
    public void saveStudent(Student student){
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Student getStudentByiD(Long id){
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
       TypedQuery<Student>typedQuery= entityManager.createQuery("select t from Student t where t.id=?1 ", Student.class);
       typedQuery.setParameter(1,id);

      Student student= typedQuery.getSingleResult();
       entityManager.getTransaction().commit();
       entityManager.close();
       return student;

    }
    public void deleteStudent(Long id){
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
        Student student=getStudentByiD(id);
        entityManager.remove(entityManager.merge(student));

    }
    public List<Student>getAllStudents(){
        EntityManager entityManager=em();
        entityManager.getTransaction().begin();
       TypedQuery<Student>typedQuery= entityManager.createQuery("select t from Student t", Student.class);
      List<Student>students= typedQuery.getResultList();
      return students;
    }
}
