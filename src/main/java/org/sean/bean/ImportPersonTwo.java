package org.sean.bean;

import org.springframework.beans.factory.annotation.Value;

public class ImportPersonTwo {
    @Value("zhangzhang")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
