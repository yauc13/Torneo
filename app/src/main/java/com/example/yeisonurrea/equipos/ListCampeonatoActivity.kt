package com.example.yeisonurrea.equipos

import android.arch.lifecycle.ViewModelStore
import android.content.Context
import android.content.Intent
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
import java.io.Serializable

class ListCampeonatoActivity : AppCompatActivity() {
    var listViewCamp: ListView? = null
    var adapterChampionShip: AdapterChampionShip? = null
    var listCamp: MutableList<Campeonato> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_campeonato)

        var bundle = intent.extras
        val user:String = bundle.getString("user")
        Toast.makeText(this, "login $user ", Toast.LENGTH_SHORT).show()

        listViewCamp = findViewById(R.id.listCam_idListCamp)
         listCamp = this.generateData()
                adapterChampionShip =  AdapterChampionShip(this,listCamp)

        listViewCamp?.adapter = adapterChampionShip
        adapterChampionShip?.notifyDataSetChanged()

        listViewCamp?.setOnItemClickListener { parent, view, position, id ->
            var cam:Campeonato  =listCamp.get(position)
            val intent = Intent(this@ListCampeonatoActivity, OptionCampeonatoActivity::class.java)

            val b = Bundle()
            b.putSerializable("cam", cam)
            intent.putExtras(b)
            startActivity(intent)
            Toast.makeText(this@ListCampeonatoActivity, "Item One selected: $position, obj name: ${cam.nameChampionShip} ",   Toast.LENGTH_SHORT).show()

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
