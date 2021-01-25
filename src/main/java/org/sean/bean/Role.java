package org.sean.bean;

public class Role {
    private String level;
    private Integer rid;

    public Role() {
        System.out.println("role 已加载");
    }

    @Override
    public String toString() {
        return "Role{" +
                "level='" + level + '\'' +
                ", rid=" + rid +
                '}';
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
