package com.example.assignment4
import java.io.Serializable

class User constructor(val _firstName: String, val _lastName: String, val _email: String, val _password: String) : Serializable {
    var firstName: String = _firstName
    var lastName: String  = _lastName
    var email: String     = _email
    var password: String  = _password
}