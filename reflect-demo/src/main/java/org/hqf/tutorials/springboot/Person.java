package org.hqf.tutorials.springboot;

import lombok.Data;

import java.util.Date;

// 示例实体类
@Data
public class Person {
    private String name;
    private int age;
    private String occupation;
    private Date birthday;

    public Person(String name, int age, String occupation,Date birthday) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.birthday = birthday;
    }


}
