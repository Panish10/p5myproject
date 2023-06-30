package com.panish.copy;

import java.util.ArrayList;
import java.util.List;

public class BookingElement {

    private String code;
    private String name;
    private Student student;
    private List<BookingElement> childElements = new ArrayList<BookingElement>(0);

    public BookingElement() {
    }

    public BookingElement(String code, String name, Student student, List<BookingElement> childElements) {
        this.code = code;
        this.name = name;
        this.student = student;
        this.childElements = childElements;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookingElement> getChildElements() {
        return childElements;
    }

    public void setChildElements(List<BookingElement> childElements) {
        this.childElements = childElements;
    }

    @Override
    public String toString() {
        return "BookingElement{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", childElements=" + childElements +
                '}';
    }
}
