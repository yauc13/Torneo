package com.example.yeisonurrea.equipos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtLogin = findViewById<EditText>(R.id.main_txtusername)
        val txtPassword = findViewById<EditText>(R.id.main_txtpassword)

        main_btnlogin.setOnClickListener({
            login(txtLogin.text.toString(), txtPassword.text.toString())
        })

    }

    fun login(txtlog : String, txtPass : String){
        if(txtlog=="yauc13" && txtPass=="123"){
            Toast.makeText(this, "login $txtlog", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, ListCampeonatoActivity::class.java)
            var dato: String = txtlog
            val b = Bundle()
            b.putString("user", dato)
            intent.putExtras(b)
            startActivity(intent)
        }else {
            Toast.makeText(this, "login y password incorrectos", Toast.LENGTH_SHORT).show()
        }
    }


}
