package com.octanner.poc.commonentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.MessageFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Howard.Fackrell
 * Date: 2/27/12
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Person {
    @Id
    Long id;
    @Column
    String name;
    @Column
    String hobby;
    @Column
    int age;

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString()
    {
        String s = MessageFormat.format("{0}s hobby is {1}", name, hobby);
        return s;

    }
}
