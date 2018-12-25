package com.example.yeisonurrea.equipos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.yeisonurrea.equipos.DataBase.UserDao
import com.example.yeisonurrea.equipos.Model.User
import com.example.yeisonurrea.equipos.R.id.main_btnlogin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var userDao : UserDao? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userDao = UserDao(this)

        val txtLogin = findViewById<EditText>(R.id.main_txtusername)
        val txtPassword = findViewById<EditText>(R.id.main_txtpassword)

        main_btnlogin.setOnClickListener{
            login(txtLogin.text.toString(), txtPassword.text.toString())
        }

        main_btnsignup.setOnClickListener{
            signup()
        }

    }


    private fun loginStatic(txtlog : String, txtPass : String){
        Toast.makeText(this, "login: $txtlog pass: $txtPass", Toast.LENGTH_SHORT).show()
            if (txtlog=="yauc13" && txtPass=="123") {
                Toast.makeText(this, "login $txtlog", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, ListCampeonatoActivity::class.java)
                var dato: String = txtlog
                val b = Bundle()
                b.putString("user", dato)
                intent.putExtras(b)
                startActivity(intent)
            } else {
                Toast.makeText(this, "login y password incorrectos", Toast.LENGTH_SHORT).show()
            }

    }

   private fun signup (){
       val intent = Intent(this@MainActivity, CreateUserActivity::class.java)
       startActivity(intent)
    }


    private fun login(txtlog : String, txtPass : String){

        if(txtlog.trim()!="" && txtPass.trim()!="") {
            var user: User? = userDao?.readUser(txtlog, txtPass)

            if (user?.userName == txtlog && user?.password == txtPass) {
                Toast.makeText(this, "login: ${user?.userName}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, ListCampeonatoActivity::class.java)
                val b = Bundle()
                b.putSerializable("user", user)
                intent.putExtras(b)
                startActivity(intent)
            } else {
                Toast.makeText(this, "login o password incorrectos", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "debe ingresar sus credenciales", Toast.LENGTH_SHORT).show()
        }
    }


}
