package com.example.yeisonurrea.equipos.Util

class Table {
    abstract class TDB{
        companion object {
            val DATABASE_NAME ="Torneo"
        }
    }

    abstract class TUser{
    companion object {
        val TABLE_USER ="user"
        val COL_USER_NAME = "username"
        val COL_USER_PASSWORD = "password"
        val COL_USER_IDUSER = "idUser"
    }
    }

}