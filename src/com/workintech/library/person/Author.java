package com.workintech.library.person;

import com.workintech.library.person.enums.Role;

public final class Author extends Person {
    public Author(long id, String name, String surname, Role role) {
        super(id, name, surname, role);
    }
}
