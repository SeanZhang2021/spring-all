package org.sean.bean;

import java.util.List;
import java.util.Map;

public class Person {
    private User user;
    private Role role;
    private Integer id;
    private Map hobbies;
    private List friends;

    public Person() {
    }

    public Person(User user, Role role, Integer id) {
        this.user = user;
        this.role = role;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "user=" + user +
                ", role=" + role +
                ", id=" + id +
                ", hobbies=" + hobbies +
                ", friends=" + friends +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map getHobbies() {
        return hobbies;
    }

    public void setHobbies(Map hobbies) {
        this.hobbies = hobbies;
    }

    public List getFriends() {
        return friends;
    }

    public void setFriends(List friends) {
        this.friends = friends;
    }
}
