package org.jpa.jpacollection;

import org.jpa.jpacollection.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest
class JpaCollectionApplicationTests {

    @PersistenceContext
    EntityManager em;

    @Test
    void contextLoads() {
    }

    @Transactional
    @Test
    public void testStudent() {
        Student student
                = new Student("Pilseong", "Heo", "heops79@gmail.com" );
        List<String> courses = student.getCourses();

        courses.add("Math");
        courses.add("Science");
        courses.add("Economics");
        courses.add("Language");
        courses.add("Language");
        em.persist(student);

        Student st1 = em.find(Student.class, 1L);
        for (String cours : st1.getCourses()) {
            System.out.println(cours);

        }

//        TypedQuery<Student> query =
//                em.createQuery("SELECT m FROM Student m", Student.class);
//
//        List<Student> resultList = query.getResultList();
//        for (Student member : resultList) {
//            System.out.println("member = " + member);
//        }
    }

}
