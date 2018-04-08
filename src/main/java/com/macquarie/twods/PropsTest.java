package com.macquarie.twods;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hopeng on 8/4/18.
 */
//@Component
@ConfigurationProperties("props.test")
public class PropsTest {

    private String name;
    private String description;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PropsTest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
