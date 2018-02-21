package com.fruitvoting.demoapp.com.fruitvoting.demoapp.dao;

import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Fruits;
import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Student;


import java.util.List;

public interface FruitDAO  {

    List getFruitVoteCount();
    void insertStudentDetails(Student student);
    List getStudentVoteDetails(String emailaddress);
    List getFruits();
    List getStudents();

}
