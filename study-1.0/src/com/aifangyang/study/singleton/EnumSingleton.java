package com.aifangyang.study.singleton;

public class EnumSingleton {
   private EnumSingleton(){

   }
   enum EnumSingletonClass{
       INSTANCE;
       private EnumSingleton instance;
       EnumSingletonClass(){
           instance = new EnumSingleton();
       }
       public EnumSingleton getInstance(){
           return instance;
       }
    }

    public static EnumSingleton getInstance(){
        return EnumSingletonClass.INSTANCE.getInstance();
    }
}
