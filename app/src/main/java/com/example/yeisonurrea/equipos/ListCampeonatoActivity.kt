package com.example.yeisonurrea.equipos

import android.arch.lifecycle.ViewModelStore
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.yeisonurrea.equipos.Adapter.AdapterChampionShip
import com.example.yeisonurrea.equipos.Model.Campeonato

class ListCampeonatoActivity : AppCompatActivity() {
    var listViewCamp: ListView? = null
    var adapterChampionShip: AdapterChampionShip? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_campeonato)

        var bundle = intent.extras
        val user:String = bundle.getString("user")
        Toast.makeText(this, "login $user ", Toast.LENGTH_SHORT).show()

        listViewCamp = findViewById<ListView>(R.id.listCam_idListCamp)
        adapterChampionShip =  AdapterChampionShip(this,generateData())

        listViewCamp?.adapter = adapterChampionShip
        adapterChampionShip?.notifyDataSetChanged()

        listViewCamp?.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@ListCampeonatoActivity, "Item One selected: $position ,parent: ${parent.getItemAtPosition(position)}",   Toast.LENGTH_SHORT).show()

        }

}

    fun viewAdminChampionShip(idChampionShip: Int){


    }


    fun generateData(): ArrayList<Campeonato> {
        var result = ArrayList<Campeonato>()

        for (i in 0..9) {
            var cham: Campeonato = Campeonato( i,"Champ $i", 1)
            result.add(cham)
        }

        return result
    }








}
