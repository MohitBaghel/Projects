package com.compose.firstprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var num : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bmi = findViewById<Button>(R.id.bmi)
        val tictac = findViewById<Button>(R.id.tictac)


        bmi.setOnClickListener {
            val intent = Intent(this ,SecondActivity::class.java)
            startActivity(intent)
        }


        tictac.setOnClickListener {
            val intent = Intent(this ,TicTacToe::class.java)
            startActivity(intent)
        }





    }


}