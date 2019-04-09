package com.example.yeisonurrea.equipos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.TabHost
import com.example.yeisonurrea.equipos.Adapter.AdapterChampionShip
import com.example.yeisonurrea.equipos.DataBase.ChampionshipDao
import com.example.yeisonurrea.equipos.Model.Championship
import com.example.yeisonurrea.equipos.Model.Group
import kotlinx.android.synthetic.main.activity_option_campeonato.*


class OptionCampeonatoActivity : AppCompatActivity() {
    private var chamDao : ChampionshipDao? =null
    var listViewCamp: ListView? = null
    var adapterChampionShip: AdapterChampionShip? = null
    var listCamp: MutableList<Championship> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_campeonato)

        chamDao = ChampionshipDao(this)
        addAllTab()
        listViewCamp = findViewById(R.id.optChamp_idListGroup)
        listCamp = this.chamDao!!.loadChampionshipByIdUser(1)
        adapterChampionShip =  AdapterChampionShip(this,listCamp)

        listViewCamp?.adapter = adapterChampionShip
        adapterChampionShip?.notifyDataSetChanged()



        var bundle = intent.extras
        val cam:Championship = bundle.getSerializable("cam") as Championship



        //val txtIdCamp = findViewById<EditText>(R.id.optCamp_txtidCamp)
        //val txtNomCamp = findViewById<EditText>(R.id.optCamp_txtName)
        //txtIdCamp.setText(cam.idChampionShip.toString())
       // txtNomCamp.setText(cam.nameChampionShip)

    }

    private fun addAllTab(){
        tab_host.setup()

        var spec = tab_host.newTabSpec("Jornadas")
        spec.setContent(R.id.tab_one)
        spec.setIndicator("Jornadas")
        tab_host.addTab(spec)


        spec = tab_host.newTabSpec("Grupos")
        spec.setContent(R.id.tab_two)
        spec.setIndicator("Grupos")
        tab_host.addTab(spec)

        spec = tab_host.newTabSpec("Goleadores")
        spec.setContent(R.id.tab_three)
        spec.setIndicator("Goleadores")
        tab_host.addTab(spec)




    }

    private fun addTab(tabHost: TabHost, name: String, indicator: String, className: Class<*>) {
        val tabSpec = tabHost.newTabSpec(name)
        tabSpec.setIndicator(indicator)
        val intent = Intent(this, className)
        tabSpec.setContent(intent)
        tabHost.addTab(tabSpec)
    }

    private fun generateData(): ArrayList<Group> {
        var result = ArrayList<Group>()

        for (i in 0..9) {
            var group = Group( i,"Group $i", 1)
            result.add(group)
        }

        return result
    }

}
