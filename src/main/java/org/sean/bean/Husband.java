package org.sean.bean;


public class Husband {
    private Wife wife;

    public Husband() {
    }

    public Husband(Wife wife2) {
        this.wife = wife2;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "wife=" + wife +
                '}';
    }
}
