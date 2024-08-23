package com.restapi.spring_crud.api.model;

public class User {
    private int _id;
    private String _firstName;
    private String _lastName;
    private String _email;


    public User(int id, String firstname, String lastname, String email) {
        _id = id;
        _firstName = firstname;
        _lastName = lastname;
        _email = email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int id) {
        _id = id;
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String firstName) {
        _firstName = firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String lastName) {
        _lastName = lastName;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String email) {
        _email = email;
    }


}
