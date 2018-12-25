package com.example.yeisonurrea.equipos.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.yeisonurrea.equipos.Util.Table
import com.example.yeisonurrea.equipos.Util.querySQL


class DataBaseHandler (context: Context) : SQLiteOpenHelper(context,Table.TDB.DATABASE_NAME,null,Table.TDB.DATABASE_VERSION){


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(querySQL.CREATE_TABLE_USER)
        db?.execSQL(querySQL.CREATE_TABLE_CHAMPIONSHIP)

    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int) {

    }





}