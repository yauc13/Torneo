package com.example.yeisonurrea.equipos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import com.example.yeisonurrea.equipos.Adapter.AdapterChampionShip
import com.example.yeisonurrea.equipos.Model.Championship
import com.example.yeisonurrea.equipos.Model.User

class ListCampeonatoActivity : AppCompatActivity() {
    var listViewCamp: ListView? = null
    var adapterChampionShip: AdapterChampionShip? = null
    var listCamp: MutableList<Championship> = mutableListOf()
    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_campeonato)

        var bundle = intent.extras
        user= bundle.getSerializable("user") as User
        Toast.makeText(this, "login list ${user?.idUser},${user?.userName} ", Toast.LENGTH_SHORT).show()

        listViewCamp = findViewById(R.id.listCam_idListCamp)
        listCamp = this.generateData()
        adapterChampionShip =  AdapterChampionShip(this,listCamp)

        listViewCamp?.adapter = adapterChampionShip
        adapterChampionShip?.notifyDataSetChanged()

        listViewCamp?.setOnItemClickListener { parent, view, position, id ->
            actionOnItemClickListener(position)
        }

}

    fun viewAdminChampionShip(idChampionShip: Int){


    }

   private fun gotoCreateChampionShip(user : User?){
        val intent = Intent(this@ListCampeonatoActivity, CreateChampionshipActivity::class.java)

        val b = Bundle()
        b.putSerializable("user", user)
        intent.putExtras(b)
        startActivity(intent)
    }

    private fun actionOnItemClickListener(position:Int){
        var cam:Championship  =listCamp.get(position)
        val intent = Intent(this@ListCampeonatoActivity, OptionCampeonatoActivity::class.java)
        val b = Bundle()
        b.putSerializable("cam", cam)
        intent.putExtras(b)
        startActivity(intent)
        Toast.makeText(this@ListCampeonatoActivity, "Item One selected: $position, obj name: ${cam.nameChampionShip} ",   Toast.LENGTH_SHORT).show()
    }




   private fun generateData(): ArrayList<Championship> {
        var result = ArrayList<Championship>()

        for (i in 0..9) {
            var cham: Championship = Championship( i,"Champ $i", 1)
            result.add(cham)
        }

        return result
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list_campeonato,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.menu_list_camp_new -> gotoCreateChampionShip(user)
        }
        return super.onOptionsItemSelected(item)
    }








}
