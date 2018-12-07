package com.example.yeisonurrea.equipos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yeisonurrea.equipos.DataBase.DataBaseHandler
import com.example.yeisonurrea.equipos.Model.User
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {
    private var db : DataBaseHandler? =null
    //var db = DataBaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        db = DataBaseHandler(this)


        crea_user_btn_insert_user.setOnClickListener{
            insertUser(crea_user_userName.text.toString(),crea_user_password.text.toString())
        }

        btn_read.setOnClickListener{
            readAllUser()
        }

        btn_update.setOnClickListener{

        }

        btn_delete.setOnClickListener{

        }
    }

    private fun insertUser (username : String, password : String){

        if (username.length > 0 && password.length > 0) {
            var user = User(crea_user_userName.text.toString(),crea_user_password.text.toString())
            var resp:Boolean? = db?.insertUser(user)
            if(resp==true){
                Toast.makeText(this," Usuario Creado Exitosamente",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Error al crear Usuario",Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show()
        }
    }

    private fun readAllUser (){
        var data = db!!.readALLUser()
        tvResult.text = ""
        for (i in 0..(data.size.minus(1))) {
            tvResult.append(data.get(i)?.idUser.toString() + " " + data.get(i).userName + " " + data.get(i).password + "\n")
        }
    }




}
