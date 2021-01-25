package org.sean.bean;

public class SpelBean {
    private Integer mark;

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SpelBean{" +
                "mark=" + mark +
                '}';
    }
}
