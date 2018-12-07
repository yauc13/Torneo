package com.example.yeisonurrea.equipos.Model

class User {
    var idUser : Int = 0;
    var userName: String = ""
    var password: String = ""

    constructor() {}

    constructor(userName: String, password: String) {
        this.userName = userName
        this.password = password
    }

    constructor(idUser : Int,userName: String, password: String) {
        this.idUser = idUser
        this.userName = userName
        this.password = password
    }
}