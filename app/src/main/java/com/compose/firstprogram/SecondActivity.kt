package com.compose.firstprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val btn  =  findViewById<Button>(R.id.calculate);
        val weightET  =  findViewById<EditText>(R.id.weight_et);
        val ftEt  =  findViewById<EditText>(R.id.heightft_et);
        val inchEt  =  findViewById<EditText>(R.id.inch_et);
        val healthTv =  findViewById<TextView>(R.id.health_tv);
        val bg =  findViewById<LinearLayout>(R.id.bg_ll);

        btn.setOnClickListener {
            if(weightET.text.toString() != ""  && weightET.text.toString()  != "0"
                && ftEt.text.toString() != ""  && inchEt.text.toString() != ""){

                val wt = (weightET.text.toString()).toDouble()
                val ft = (ftEt.text.toString()).toDouble()
                val inch = (inchEt.text.toString()).toDouble()

try {
    val totalInch = (ft * 12) + inch;
    val totalcm = totalInch * 2.54;

    val totalM = totalcm / 100;

    val bmi = wt / (totalM * totalM);

    if(bmi > 25) {
        // overweight
        healthTv.text = "You are overweight";
        bg.setBackgroundColor(resources.getColor(R.color.yellow))
        Toast.makeText(this, "You are overweight", Toast.LENGTH_SHORT).show()
    } else if(bmi < 18){
        healthTv.text = "You are underweight";
        bg.setBackgroundColor(resources.getColor(R.color.red))
        Toast.makeText(this, "You are underweight", Toast.LENGTH_SHORT).show()
    } else {
        healthTv.text = "You are Fit";
        bg.setBackgroundColor(resources.getColor(R.color.blue))
        Toast.makeText(this, "You are fit", Toast.LENGTH_SHORT).show()
    }

} catch(e : Exception){
    Log.d("Issue", e.toString())
}





            } else {
                Toast.makeText(this, "Please enter valid details", Toast.LENGTH_SHORT).show()
            }
        }



    }


//Api -> Retrofit -> client -> Api Interface -> figma/Adobe xd






}








