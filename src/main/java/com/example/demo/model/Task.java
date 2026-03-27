package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String status;

    //constructor
    public Task(){}
    public Task( String name, String status){
        this.name=name;
        this.status=status;
    }
    //Getters and Setters
    public int getId(){ return id;}
    public void setId(int id){ this.id=id;}

    public String getName(){return name; }
    public void setName(String name){this.name=name;}

    public String getStatus(){ return status;}
    public void setStatus(String status){ this.status=status;}
}
