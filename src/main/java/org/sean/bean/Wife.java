package org.sean.bean;

public class Wife {
    private String name;

    public Wife(String name) {
        this.name = name;
    }

    @Override
    public String
    toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                '}';
    }
}
