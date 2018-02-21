package com.fruitvoting.demoapp.com.fruitvoting.demoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name = "fruits")
@Table(name = "fruits")
@JsonIgnoreProperties(allowGetters = true)
public class Fruits implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fruitid")
    private int fruitId;

    @NotNull
    @Column(name = "fruitname")
    private String fruitName;
//    @OneToOne(mappedBy = "fruits")
//
//    @OneToOne(fetch = FetchType.LAZY,mappedBy = "fruits")
//    private Student student;
//
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "fruitId=" + fruitId +
                ", fruitName='" + fruitName + '\'' +
                '}';
    }
}
