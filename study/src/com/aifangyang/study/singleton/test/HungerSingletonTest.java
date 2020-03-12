package com.aifangyang.study.singleton.test;

import com.aifangyang.study.singleton.EnumSingleton;
import com.aifangyang.study.singleton.InnerClassSingleton;
import com.aifangyang.study.singleton.LazySingleton;
import com.aifangyang.study.singleton.thread.ThreadHunger;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class HungerSingletonTest {
    public static void main(String[] args) {
        /*ThreadHunger threadHunger1 = new ThreadHunger();
        ThreadHunger threadHunger2 = new ThreadHunger();
        threadHunger1.setName("thread1");
        threadHunger2.setName("thread2");
        threadHunger1.start();
        threadHunger2.start();
        System.out.println("END");*/

        /*try {
            // 反射破坏单例
            Class<?> innerClassSingletonClass = InnerClassSingleton.class;
            Constructor<?>[] declaredConstructors = innerClassSingletonClass.getDeclaredConstructors();
            declaredConstructors[0].setAccessible(true);
            InnerClassSingleton Obj1 =(InnerClassSingleton)declaredConstructors[0].newInstance();
            InnerClassSingleton Obj2 = (InnerClassSingleton)declaredConstructors[0].newInstance();
            if(Obj1==Obj2){
                System.out.println("创建不同对象失败，是单例的");
            }else{
                System.out.println("创建不同对象成功，非完全的单例");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

        try{
            // 序列化和反序列化破坏双重校验
            //Write Obj to file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(LazySingleton.getInstance());
            oos.close();
            //Read Obj from file
            File file = new File("tempFile");
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
            LazySingleton newInstance = (LazySingleton) ois.readObject();
            ois.close();
            // 判断是否是同一个对象
            System.out.println(newInstance == LazySingleton.getInstance());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
