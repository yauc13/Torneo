package com.example.yeisonurrea.equipos.Util

abstract class querySQL {
    companion object {
        val CREATE_TABLE_USER = "CREATE TABLE " + Table.TUser.TABLE_USER +" (" +
                Table.TUser.COL_USER_IDUSER +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                Table.TUser.COL_USER_NAME + " VARCHAR(20)," +
                Table.TUser.COL_USER_PASSWORD +" VARCHAR(20))"

        val CREATE_TABLE_CHAMPIONSHIP = "CREATE TABLE " + Table.TChampionShip.TABLE_CHAMPIONSHIP +" (" +
                Table.TChampionShip.COL_CHAMP_IDCHAMP +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                Table.TChampionShip.COL_CHAMP_NAME + " VARCHAR(20)," +
                Table.TUser.COL_USER_IDUSER +" INTEGER,"+
                "FOREIGN KEY("+Table.TUser.COL_USER_IDUSER+") REFERENCES "+Table.TUser.TABLE_USER+" ("+Table.TUser.COL_USER_IDUSER+"))"

        val CREATE_TABLE_GROUP = "CREATE TABLE " + Table.TGroup.TABLE_GROUP +" (" +
                Table.TGroup.COL_GROUP_IDGROUP +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                Table.TGroup.COL_GROUP_NAME + " VARCHAR(20)," +
                Table.TChampionShip.COL_CHAMP_IDCHAMP +" INTEGER,"+
                "FOREIGN KEY("+ Table.TChampionShip.COL_CHAMP_IDCHAMP+") REFERENCES "+Table.TChampionShip.TABLE_CHAMPIONSHIP+" ("+Table.TChampionShip.COL_CHAMP_IDCHAMP+"))"


        val SELECT_USER_LOGIN = "SELECT * FROM " + Table.TUser.TABLE_USER + " WHERE " + Table.TUser.COL_USER_NAME +" = ? AND " + Table.TUser.COL_USER_PASSWORD+" = ? "
        val SELECT_CHAMP_BY_IDUSER = "SELECT * FROM " + Table.TChampionShip.TABLE_CHAMPIONSHIP +" WHERE " + Table.TUser.COL_USER_IDUSER +" = ?"
        val SELECT_GROUP_BY_IDCHAMP = "SELECT * FROM " + Table.TGroup.TABLE_GROUP +" WHERE " + Table.TChampionShip.COL_CHAMP_IDCHAMP +" = ?"

    }
}