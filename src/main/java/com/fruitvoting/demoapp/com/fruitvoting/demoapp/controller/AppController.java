package com.fruitvoting.demoapp.com.fruitvoting.demoapp.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fruitvoting.demoapp.com.fruitvoting.demoapp.dao.FruitDAO;
import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Fruits;
import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.Student;
import com.fruitvoting.demoapp.com.fruitvoting.demoapp.model.VoteCount;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@ComponentScan(basePackages = "com.fruitvotingapp.demoapp.model")
@RestController
@RequestMapping(value="/votingapp")
@CrossOrigin("*")
public class AppController implements AppControllerI {

    @Autowired
    private FruitDAO fruitDAO;


    @RequestMapping(value = "/getfruits",method = RequestMethod.GET,produces = "application/json")
    public List getFruits(){
        return fruitDAO.getFruits();
    }

    @RequestMapping(value = "/getstudents",method = RequestMethod.GET,produces = "application/json")
    public List<Student> getStudents(){
        return fruitDAO.getStudents();
    }

    @RequestMapping(value = "/getvotecount" ,method = RequestMethod.GET,produces = "application/json")
    @Override
    public List<VoteCount> getFruitVoteCount() {
        System.out.println("get vote controller");

        return fruitDAO.getFruitVoteCount();
    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST,produces = "application/json")
    @Transactional
    public void insertStudentDetails(@RequestBody String payload){
        String temppayload = payload.toLowerCase();
        JSONParser jsonParser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = mapper.readValue(payload, Student.class);
            System.out.println("Java object created from JSON String :");
            System.out.println(student);
            fruitDAO.insertStudentDetails(student);

        }
        catch (JsonGenerationException ex) {
            ex.printStackTrace();
        } catch (JsonMappingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    @RequestMapping(value = "/getstudentvote/{emailaddress}/",method = RequestMethod.GET)
    @Override
    public List getStudentVoteDetails(@PathVariable("emailaddress") String emailaddress) {
        return fruitDAO.getStudentVoteDetails(emailaddress);
    }
}
