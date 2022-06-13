/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eradaw.springProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pujawadare
 */
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "subject")
    private String subject;
    
    @Column(name = "email")
    private String email;
    
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
	this.name = name;
    }
    public void setSubject(String subject) {
	this.subject = subject;
    }
    public void setEmail(String email) {
	this.email = email;
    }
    
    public long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getSubject() {
        return this.subject;
    }
    public String getEmail() {
        return this.email;
    }
}
