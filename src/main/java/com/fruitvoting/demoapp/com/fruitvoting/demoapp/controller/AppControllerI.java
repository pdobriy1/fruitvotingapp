package com.fruitvoting.demoapp.com.fruitvoting.demoapp.controller;

import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Fruits;
import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Student;

import java.util.List;

public interface AppControllerI {

    List getFruitVoteCount();
//    void insertStudentDetails(Student student);
    List getStudentVoteDetails(String emailaddress);
}
