package com.example.yeisonurrea.equipos.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.yeisonurrea.equipos.Model.Team
import com.example.yeisonurrea.equipos.Util.Table

class TeamDao {

    private val db : SQLiteDatabase

    private var handler : DataBaseHandler? =null

    constructor(context: Context){

        handler = DataBaseHandler(context)
        db = handler!!.writableDatabase

    }

    fun insertTeam(team : Team) : Boolean{
        var resp= false
        var cv = ContentValues()
        cv.put(Table.TTeam.COL_TEAM_NAMETEAM,team.nameTeam)
        cv.put(Table.TChampionShip.COL_CHAMP_IDCHAMP,team.idChampionship)
        var result = db.insert(Table.TUser.TABLE_USER,null,cv)
        if(result >= -1.toLong()) {
            resp = true
            //Toast.makeText(context,"Error al crear usuario",Toast.LENGTH_SHORT).show()
        }

        return resp
    }
}