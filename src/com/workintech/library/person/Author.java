package com.workintech.library.person;

import com.workintech.library.person.enums.Role;

public class Author extends Person {
    public Author(long id, String name, String surname, Role role) {
        super(id, name, surname, role);
    }
}
