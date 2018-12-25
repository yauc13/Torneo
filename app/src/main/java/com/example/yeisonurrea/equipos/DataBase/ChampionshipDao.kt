package com.example.yeisonurrea.equipos.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.yeisonurrea.equipos.Model.Championship
import com.example.yeisonurrea.equipos.Util.Table
import com.example.yeisonurrea.equipos.Util.querySQL

class ChampionshipDao {
    private val db : SQLiteDatabase

    private var handler : DataBaseHandler? =null

    constructor(context: Context){

        handler = DataBaseHandler(context)
        db = handler!!.writableDatabase

    }

    fun insertChampionship(championship : Championship) : Boolean{
        var resp= false
        var cv = ContentValues()
        cv.put(Table.TChampionShip.COL_CHAMP_NAME, championship.nameChampionShip)
        cv.put(Table.TUser.COL_USER_IDUSER,championship.idUser)
        var result = db.insert(Table.TChampionShip.TABLE_CHAMPIONSHIP,null,cv)
        if(result >= -1.toLong()) {
            resp = true
            
        }

        return resp
    }

    fun readALLUser(idUser: Int) : MutableList<Championship>{
        var list : MutableList<Championship> = ArrayList()
        val query = querySQL.SELECT_CHAMP_BY_IDUSER
        val result = db.rawQuery(query,arrayOf(idUser.toString()))
        if(result.moveToFirst()){
            do {
                var cham = Championship()
                cham.idChampionShip = result.getInt(result.getColumnIndex(Table.TChampionShip.COL_CHAMP_IDCHAMP))
                cham.nameChampionShip = result.getString(result.getColumnIndex(Table.TChampionShip.COL_CHAMP_NAME))
                cham.idUser= result.getInt(result.getColumnIndex(Table.TUser.COL_USER_IDUSER))
                list.add(cham)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

}