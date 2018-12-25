package com.example.yeisonurrea.equipos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TabHost
import kotlinx.android.synthetic.main.activity_option_campeonato.*


class OptionCampeonatoActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_campeonato)

        addAllTab()


        //var bundle = intent.extras
        //val cam:Campeonato = bundle.getSerializable("cam") as Campeonato

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

}
