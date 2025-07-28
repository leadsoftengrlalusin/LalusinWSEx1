package org.gcash.training.codes.model;

import jakarta.json.bind.annotation.JsonbTransient;

import jakarta.xml.bind.annotation.XmlTransient;

public class Sailor {

    private long id;
    private int sid;
    private String name;
    private int rating;
    private int age;

    public Sailor() {
    }

    public Sailor(long id, int sid, String name, int rating, int age) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.rating = rating;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonbTransient
    @XmlTransient
    public boolean isSenior() {
        return age > 40;
    }
}
