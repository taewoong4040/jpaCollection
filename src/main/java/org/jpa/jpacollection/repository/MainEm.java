package org.jpa.jpacollection.repository;

import org.jpa.jpacollection.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MainEm {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public Long insert(Student student) {
        em.persist(student);
        return student.getId();
    }

    @Transactional
    public void update(Student student) {

        em.merge(student);
    }

    public Student findById(Long id) {
        Student student = em.find(Student.class, id);
        return student;
    }

    @Transactional
    public void insertNewCourse(Long id, String course) {
        Student student = em.find(Student.class, id);
        List<String> courses = student.getCourses();
        courses.add(course);
    }

    @Transactional
    public void deleteById(Long id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

    public List<Student> findAll() {
        String sql = "select m from Student m";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);

        List<Student> list = query.getResultList();
        return list;
    }
}
