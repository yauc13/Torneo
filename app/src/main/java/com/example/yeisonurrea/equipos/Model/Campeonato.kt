package com.example.yeisonurrea.equipos.Model

class Campeonato {
    var idChampionShip: Int = 0
    var nameChampionShip: String = ""
    var idUser: Int = 0

    constructor() {}

    constructor(idChampionShip: Int ,nameChampionShip: String, idUser: Int) {
        this.idChampionShip = idChampionShip
        this.nameChampionShip = nameChampionShip
        this.idUser = idUser
    }
}