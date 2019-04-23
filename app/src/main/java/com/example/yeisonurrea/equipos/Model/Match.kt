package com.example.yeisonurrea.equipos.Model

import java.io.Serializable

class Match: Serializable {
    var idMatch: Int = 0
    var idTeamA: Int = 0
    var idTeamB: Int = 0
    var idGroup: Int = 0
    var idPlayOff: Int = 0
    var stateMatch: String =""
    var idFixture: Int = 0
    var idReferee: Int = 0
}