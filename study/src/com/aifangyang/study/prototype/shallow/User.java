package com.aifangyang.study.prototype.shallow;

import lombok.Data;

import java.util.List;

@Data
public class User implements Cloneable {
    private String userType;
    private String name;
    private int age;
    private List<String> infos;

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "userType='" + userType + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", infos=" + infos +
                '}';
    }
}
