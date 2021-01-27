package org.sean.bean;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String userName;
    private LocalDate birthDate;

    public User() {
        System.out.println("user已加载，使用默认空构造函数");
    }

    public User(Integer id) {
        this.id = id;
        System.out.println("user的构造方法被调用了");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        System.out.println("user的setId被调用了");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
