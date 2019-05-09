package com.test.reflection;

import lombok.extern.slf4j.Slf4j;
import org.smartreport.ReportBean;
import org.smartreport.test.TestChart1;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestRef {
    public static void main(String[] args) {
        Person person = new Person();
        Field field = ReflectionUtils.findField(Person.class, "name");
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, person, "hhahaha");
        log.info(person.getName());
    }
    private static List<String> getFieldNames(Field[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fields)
            fieldNames.add(field.getName());
        return fieldNames;
    }
}
