package com.example.yeisonurrea.equipos.Model

import java.io.Serializable

class Group: Serializable {
    var idGroup: Int = 0
    var nameGroup: String = ""
    var idChampionship: Int = 0

    constructor()

    constructor(nameGroup: String, idChampionship: Int) {
        this.nameGroup = nameGroup
        this.idChampionship = idChampionship
    }

    constructor(idGroup: Int ,nameGroup: String, idChampionship: Int) {
        this.idGroup = idGroup
        this.nameGroup = nameGroup
        this.idChampionship = idChampionship
    }
}