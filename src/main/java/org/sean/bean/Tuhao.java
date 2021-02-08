package org.sean.bean;

/**
 * 土豪
 */
public class Tuhao {
    private String name;
    private Integer money;
    private Integer age;

    @Override
    public String toString() {
        return "Tuhao{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
