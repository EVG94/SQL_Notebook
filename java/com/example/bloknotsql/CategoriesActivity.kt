package com.example.bloknotsql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bloknotsql.R
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        relBloknote.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, " Bloknote is ready!", Toast.LENGTH_SHORT).show()

        }

        relDostijeniya.setOnClickListener {

            val intent = Intent(this, DostijeniyaActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "  is ready!", Toast.LENGTH_SHORT).show()

        }
        myCalendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "  is ready!", Toast.LENGTH_SHORT).show()

        }
        relMaps.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "  its ready!", Toast.LENGTH_SHORT).show()

        }



    }
}