package com.example.yeisonurrea.equipos.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.yeisonurrea.equipos.Model.User
import com.example.yeisonurrea.equipos.Util.Table
import com.example.yeisonurrea.equipos.Util.querySQL


class UserDao {
    private val db : SQLiteDatabase

    private var handler : DataBaseHandler? =null

    constructor(context: Context){

        handler = DataBaseHandler(context)
        db = handler!!.writableDatabase

    }

    fun insertUser(user : User) : Boolean{
        var resp= false
        var cv = ContentValues()
        cv.put(Table.TUser.COL_USER_NAME,user.userName)
        cv.put(Table.TUser.COL_USER_PASSWORD,user.password)
        var result = db.insert(Table.TUser.TABLE_USER,null,cv)
        if(result >= -1.toLong()) {
            resp = true
            //Toast.makeText(context,"Error al crear usuario",Toast.LENGTH_SHORT).show()
        }

        return resp
    }

    fun readALLUser() : MutableList<User>{
        var list : MutableList<User> = ArrayList()


        val query = "Select * from " + Table.TUser.TABLE_USER
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = User()
                user.idUser = result.getString(result.getColumnIndex(Table.TUser.COL_USER_IDUSER)).toInt()
                user.userName = result.getString(result.getColumnIndex(Table.TUser.COL_USER_NAME))
                user.password = result.getString(result.getColumnIndex(Table.TUser.COL_USER_PASSWORD))
                list.add(user)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readUser(nameUser: String, password: String) : User {
        var user = User()
        val query = querySQL.SELECT_USER_LOGIN
        val result = db.rawQuery(query,arrayOf(nameUser,password))
        if(result.count >0) {
            if (result.moveToFirst()) {
                do {

                    user.idUser = result.getString(result.getColumnIndex(Table.TUser.COL_USER_IDUSER)).toInt()
                    user.userName = result.getString(result.getColumnIndex(Table.TUser.COL_USER_NAME))
                    user.password = result.getString(result.getColumnIndex(Table.TUser.COL_USER_PASSWORD))

                } while (result.moveToNext())
            }
        }
        result.close()
        db.close()
        return user
    }

    fun deleteData(){

        db.delete(Table.TUser.TABLE_USER,null,null)
        db.close()
    }


    fun updateData() {

        val query = "Select * from " + Table.TUser.TABLE_USER
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var cv = ContentValues()
                cv.put(Table.TUser.COL_USER_PASSWORD,(result.getInt(result.getColumnIndex(Table.TUser.COL_USER_PASSWORD))+1))
                db.update(Table.TUser.TABLE_USER,cv, Table.TUser.COL_USER_IDUSER + "=?  ", arrayOf(result.getString(result.getColumnIndex(Table.TUser.COL_USER_IDUSER))))
            }while (result.moveToNext())
        }

        result.close()
        db.close()
    }

}