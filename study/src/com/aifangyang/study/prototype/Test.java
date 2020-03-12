package com.aifangyang.study.prototype;

import com.aifangyang.study.prototype.deep.ConcretePrototype;
import com.aifangyang.study.prototype.shallow.User;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*User user = new User();
        user.setAge(12);
        user.setName("Tom");
        List<String> infoList = new ArrayList<String>();
        infoList.add("reading");
        infoList.add("writing");
        user.setInfos(infoList);
        User userCopy = null;
        try {
            userCopy = user.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(user == userCopy);
        System.out.println(user.getInfos() == userCopy.getInfos());*/

        //创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);

        //拷贝原型对象
        ConcretePrototype cloneType = prototype.deepCloneHobbies();
        cloneType.getHobbies().add("技术控");

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());

        ConcretePrototype concretePrototype = prototype.deepClone();
        concretePrototype.getHobbies().add("看小黄书");

        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + concretePrototype.getHobbies());
        System.out.println(prototype.getHobbies() == concretePrototype.getHobbies());

    }
}
