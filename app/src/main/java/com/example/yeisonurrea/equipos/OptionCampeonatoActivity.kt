package com.example.yeisonurrea.equipos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_option_campeonato.*

class OptionCampeonatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_campeonato)

        opt_cam_btn.setOnClickListener({
            Toast.makeText(this, "clikk", Toast.LENGTH_SHORT).show()
        })
    }
}
