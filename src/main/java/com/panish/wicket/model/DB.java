package com.panish.wicket.model;

import java.util.ArrayList;
import java.util.List;

public class DB {

    public static Person getPerson() {
        Person person = new Person("Panish", "Pawade", "pune", "p@gmail.com", "412101");
        Person spouse = new Person("Neha", "Pawade");

        List<Person> children = new ArrayList<>();

        Person child1 = new Person("child1", "Pawade");
        Person child2 = new Person("child2", "Pawade");
        children.add(child1);
        children.add(child2);

        person.setSpouse(spouse);
        person.setChildren(children);

        return person;
    }
}
