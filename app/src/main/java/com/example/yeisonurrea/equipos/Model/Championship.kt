package com.example.yeisonurrea.equipos.Model

import java.io.Serializable

class Championship: Serializable {
    var idChampionShip: Int = 0
    var nameChampionShip: String = ""
    var idUser: Int = 0

    constructor()

    constructor(nameChampionShip: String, idUser: Int) {
        this.nameChampionShip = nameChampionShip
        this.idUser = idUser
    }

    constructor(idChampionShip: Int ,nameChampionShip: String, idUser: Int) {
        this.idChampionShip = idChampionShip
        this.nameChampionShip = nameChampionShip
        this.idUser = idUser
    }
}