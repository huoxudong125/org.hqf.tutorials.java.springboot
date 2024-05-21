package org.hqf.tutorials.springboot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    private static final String format = "yyyy-MM-dd";

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Map<String, String> propertyToColumnMap = new HashMap<>();
        propertyToColumnMap.put("name", "name");
        propertyToColumnMap.put("age", "age");
        propertyToColumnMap.put("birthday", "birth_day");


        Person person1 = new Person("Alice", 25, "Engineer", convert2Date("2020-01-01"));
        Person person2 = new Person("Bob", 30, "Teacher", convert2Date("2020-01-01"));
        Person person3 = new Person("Charlie", 35, "Doctor", convert2Date("2020-01-01"));

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        // 单个实体的属性读取
        System.out.println("Single object properties:");
        String whereClause = MyReflectionUtils.buildWhereClause(personList, Arrays.asList("name", "age", "birthday"), propertyToColumnMap);
        System.out.println(whereClause);


    }

    private static Date convert2Date(String dateString) {

        // Convert LocalDate to Date using toInstant() and atStartOfDay()
        LocalDate parsedDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format));
        // Convert to java.util.Date using Calendar
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, parsedDate.getYear());
        cal.set(Calendar.MONTH, parsedDate.getMonthValue() - 1); // Month is 0-based
        cal.set(Calendar.DAY_OF_MONTH, parsedDate.getDayOfMonth());

        Date convertedDate = cal.getTime();

        return convertedDate;
    }
}