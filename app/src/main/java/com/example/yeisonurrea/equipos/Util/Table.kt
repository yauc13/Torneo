package com.example.yeisonurrea.equipos.Util

class Table {
    abstract class TDB{
        companion object {
            val DATABASE_NAME = "Torneo"
            val DATABASE_VERSION = 1
        }
    }

    abstract class TUser{
        companion object {
            val TABLE_USER = "user"
            val COL_USER_NAME = "username"
            val COL_USER_PASSWORD = "password"
            val COL_USER_IDUSER = "idUser"
        }
    }

    abstract class TChampionShip{
        companion object {
            val TABLE_CHAMPIONSHIP = "championship"
            val COL_CHAMP_IDCHAMP = "idChampionship"
            val COL_CHAMP_NAME = "nameChampionship"

        }
    }

}