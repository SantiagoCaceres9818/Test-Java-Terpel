package com.test.terpel.app.test_terpel.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Client {

   
    private Long id;
    private String name;
    private String identity;
    private LocalDate birthday;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
}
