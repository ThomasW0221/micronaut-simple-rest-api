package io.twinterf.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friend {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String greeting;

    public Friend() {
    }

    public Friend(String name, String greeting) {
        this.name = name;
        this.greeting = greeting;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }


}
