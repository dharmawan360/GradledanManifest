package com.example.gradledanmanifest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnNegara = findViewById<Spinner>(R.id.spnNegara)
        val civNegara = findViewById<CircleImageView>(R.id.civNegara)

        val nmNegara = arrayOf(
            "Brunei Darussalam","Filipina","Indonesia","Kamboja","Laos","Malaysia",
            "Myanmar","Singapura","Thailand","Timor Leste","Vietnam"
        )
        spnNegara.adapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            nmNegara
        )
        val baseUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/"
        val bendera = arrayOf(
            "9/9c/Flag_of_Brunei.svg/125px-Flag_of_Brunei.svg.png",
            "9/99/Flag_of_the_Philippines.svg/125px-Flag_of_the_Philippines.svg.png",
            "9/9f/Flag_of_Indonesia.svg/125px-Flag_of_Indonesia.svg.png",
            "8/83/Flag_of_Cambodia.svg/125px-Flag_of_Cambodia.svg.png",
            "5/56/Flag_of_Laos.svg/125px-Flag_of_Laos.svg.png",
            "6/66/Flag_of_Malaysia.svg/125px-Flag_of_Malaysia.svg.png",
            "8/8c/Flag_of_Myanmar.svg/125px-Flag_of_Myanmar.svg.png",
            "4/48/Flag_of_Singapore.svg/125px-Flag_of_Singapore.svg.png",
            "a/a9/Flag_of_Thailand.svg/125px-Flag_of_Thailand.svg.png",
            "2/26/Flag_of_East_Timor.svg/125px-Flag_of_East_Timor.svg.png",
            "2/21/Flag_of_Vietnam.svg/125px-Flag_of_Vietnam.svg.png"
        )
        spnNegara.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Picasso.get().load("$baseUrl${bendera[position]}").fit().into(civNegara)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}