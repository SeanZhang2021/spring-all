package org.sean.bean;

public class Bro {
    private String name;

    @Override
    public String toString() {
        return "Bro{" +
                "name='" + name + '\'' +
                '}';
    }

    public Bro() {
    }

    public Bro(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
