package com.panish.copy;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentImpl {

    public static void main(String[] args) {
        StudentImpl obj = new StudentImpl();
        //obj.m2();
    }

    private void m2() {
        Student s1 = new Student("panish","pune");
        Student s2 = new Student("neha","pune");
        List<Student> list = Arrays.asList(s1, s2);

        Student s3 = list.stream().filter(item -> item.getName().equals("panish")).findFirst().get();
        s3.setCity("Amravati");
        System.out.println(list);
        System.out.println(s3);
    }

    private void m1() {
        Class clazz = BookingElement.class;
        System.out.println("Class name: " + clazz);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //System.out.println("Field Name: " + field);
        }

        BookingElement b1 = new BookingElement();
        BookingElement b2 = new BookingElement("1001", "Fire", null, null);

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                //field.set(b1, field.toString()+"");
                //System.out.println(b1);
                System.out.println(field.getName() +": "+field.get(b2));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(b1);
    }

    private void copyExample(){
        BookingElement b1 = new BookingElement("1001", "Fire", new Student("panish", "pune"), null);
        //BookingElement child1 = new BookingElement("1002", "Premium", null);
        //List<BookingElement> children = new ArrayList<>();
        //children.add(child1);

        //b1.setChildElements(children);
        BookingElement b2 = null;
        try {
            b2 = copy(b1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        b1.setName("Ter");
        b1.getStudent().setName("neha");

        //BookingElement child2 = new BookingElement("1002", "Rouding", null);
        //List<BookingElement> children2 = new ArrayList<>();
       // children2.add(child1);

        //b1.setChildElements(children2);
       // b1.getChildElements().get(0).setName("rouding");

        System.out.println(b1);
        System.out.println(b2);
    }

    private <T> T copy(T entity) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = entity.getClass();
        T newEntity = (T) entity.getClass().newInstance();

        while (clazz != null) {
            copyFields(entity, newEntity, clazz);
            clazz = clazz.getSuperclass();
        }

        return newEntity;
    }

    private <T> T copyFields(T entity, T newEntity, Class<?> clazz) throws IllegalAccessException {
        List<Field> fields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fields.add(field);
        }
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(newEntity, field.get(entity));
        }
        return newEntity;
    }
}
