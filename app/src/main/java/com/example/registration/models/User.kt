package com.example.registration.models

class User {
    var fullName :String = ""
    var email:String = ""
    var password:String= ""

    constructor(fullName:String, email:String,password:String ){
        this.fullName =fullName
        this.email=email
        this.password = password
    }

    constructor()
}