package com.fruitvoting.demoapp.com.fruitvoting.demoapp.dao;

import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Fruits;
import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class FruitDAOImpl  implements FruitDAO{

    @PersistenceContext
    EntityManager entityManager;

    public List getFruits(){
        Query query = entityManager.createNativeQuery("SELECT fruitid,fruitname FROM fruits");
        List list = query.getResultList();
        return list;
    }

    public List getStudents(){
        Query query = entityManager.createNativeQuery
                ("SELECT studentid,firstname,lastname,emailaddress,studentfruitid " +
                        "FROM students");
        List list = query.getResultList();
        return list;
    }

    @Override
    public List getFruitVoteCount() {
        Query query = entityManager.createNativeQuery("select f.fruitid,f.fruitname,count(f.fruitid) as votes from students s\n" +
                "join fruits f\n" +
                "on s.studentfruitid=f.fruitid\n" +
                "group by fruitid \n" +
                "order by votes desc");
        List list = query.getResultList();
        return list;
    }

    @Override
    public void insertStudentDetails(Student student) {
        Query query =entityManager.
                createNativeQuery
                        ("insert into " +
                 "students(studentid,firstname,lastname,emailaddress,studentfruitid) " +
                "values(null,?,?,?,?)");
        System.out.println("student firstname"+student.getFirstname());
        query.setParameter(1,student.getFirstname());
        query.setParameter(2,student.getLastname());
        query.setParameter(3,student.getEmailaddress());
        query.setParameter(4,student.getFruitId());
        query.executeUpdate();
    }

    @Override
    public List getStudentVoteDetails(String emailaddress) {
        System.out.println("email address"+emailaddress);

        Query query = entityManager.createNativeQuery(
                ("select s.studentid,s.firstname,s.lastname,s.emailaddress,\n" +
                        " s.studentfruitid,f.fruitname\n" +
                        " from students s join fruits f\n" +
                        " ON s.studentfruitid = f.fruitid\n" +
                        " WHERE s.emailaddress = ? "));

        query.setParameter(1,emailaddress);
        List list = query.getResultList();
        System.out.println(emailaddress);
        return list;
    }
}
