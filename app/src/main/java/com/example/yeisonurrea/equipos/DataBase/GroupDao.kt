package com.example.yeisonurrea.equipos.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.yeisonurrea.equipos.Model.Group

import com.example.yeisonurrea.equipos.Util.Table
import com.example.yeisonurrea.equipos.Util.querySQL

class GroupDao {
    private val db : SQLiteDatabase

    private var handler : DataBaseHandler? =null

    constructor(context: Context){

        handler = DataBaseHandler(context)
        db = handler!!.writableDatabase

    }

    fun insertGroup(group : Group) : Boolean{
        var resp= false
        var cv = ContentValues()
        cv.put(Table.TGroup.COL_GROUP_NAME, group.nameGroup)
        cv.put(Table.TChampionShip.COL_CHAMP_IDCHAMP,group.idChampionship)
        var result = db.insert(Table.TGroup.TABLE_GROUP,null,cv)
        if(result >= -1.toLong()) {
            resp = true

        }

        return resp
    }

    fun loadChampionshipByIdUser(idUser: Int) :ArrayList<Group>{
        var list = ArrayList<Group>()
        val query = querySQL.SELECT_CHAMP_BY_IDUSER
        val result = db.rawQuery(query,arrayOf(idUser.toString()))
        if(result.moveToFirst()){
            do {
                var group = Group()
                group.idGroup = result.getInt(result.getColumnIndex(Table.TGroup.COL_GROUP_IDGROUP))
                group.nameGroup = result.getString(result.getColumnIndex(Table.TGroup.COL_GROUP_NAME))
                group.idChampionship= result.getInt(result.getColumnIndex(Table.TChampionShip.COL_CHAMP_IDCHAMP))
                list.add(group)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

}