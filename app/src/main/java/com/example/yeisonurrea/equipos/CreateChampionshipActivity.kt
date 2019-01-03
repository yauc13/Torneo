package com.example.yeisonurrea.equipos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yeisonurrea.equipos.DataBase.ChampionshipDao
import com.example.yeisonurrea.equipos.Model.Championship
import com.example.yeisonurrea.equipos.Model.User
import kotlinx.android.synthetic.main.activity_create_championship.*


class CreateChampionshipActivity : AppCompatActivity() {
    private var chamDao : ChampionshipDao? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_championship)
        chamDao = ChampionshipDao(this)

        var bundle = intent.extras
        val user: User = bundle.getSerializable("user") as User
        Toast.makeText(this, "login list ${user.userName},${user.idUser} ", Toast.LENGTH_SHORT).show()


        crea_cham_btncrear.setOnClickListener {
            insertChampionship(crea_cham_name.text.toString(),1)
        }




    }

   private fun insertChampionship(name: String, idUser: Int){
       if (name.isNotEmpty()) {
           var cham = Championship(name,idUser)
           var resp:Boolean? = chamDao?.insertChampionship(cham)
           if(resp==true){
               Toast.makeText(this," Campeonato Creado Exitosamente",Toast.LENGTH_SHORT).show()
           }else{
               Toast.makeText(this,"Error al crear Campeonato",Toast.LENGTH_SHORT).show()
           }
       } else {
           Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show()
       }
   }



}
