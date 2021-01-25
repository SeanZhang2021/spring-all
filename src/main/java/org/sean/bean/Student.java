package org.sean.bean;

public class Student {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 工厂Bean时，需要无参构造函数
     */
    public Student() {

    }

    public Student(Integer id) {
        System.out.println("student单个参数构造函数加载");
        this.id = id;
    }

    /**
     * 静态工厂
     *
     * @return
     */
    public static Student createStudent() {
        return new Student(2);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
