package com.example.yeisonurrea.equipos.Util

abstract class querySQL {
    companion object {
        val CREATE_TABLE_USER = "CREATE TABLE " + Table.TUser.TABLE_USER +" (" +
                Table.TUser.COL_USER_IDUSER +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                Table.TUser.COL_USER_NAME + " VARCHAR(20)," +
                Table.TUser.COL_USER_PASSWORD +" VARCHAR(20))"

        val SELECT_USER_LOGIN = "SELECT * FROM " + Table.TUser.TABLE_USER + " WHERE " + Table.TUser.COL_USER_NAME +" = ? AND " + Table.TUser.COL_USER_PASSWORD+" = ? "


    }
}