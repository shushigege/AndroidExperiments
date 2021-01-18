package com.example.androidexperiments.experiment3.bmob;

import cn.bmob.v3.BmobObject;

public class Person extends BmobObject {
    private String username;
    private String password;
    private String name;
    private String email;
    private String sex;
    private String age;
    private String hobby;

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getSex(){
        return sex;
    }
    public String  getAge(){
        return age;
    }

    public String getHobby(String hobby){
        return hobby;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


}
