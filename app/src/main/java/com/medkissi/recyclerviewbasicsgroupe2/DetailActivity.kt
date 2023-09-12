package com.medkissi.recyclerviewbasicsgroupe2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.medkissi.recyclerviewbasicsgroupe2.model.Animal
import com.medkissi.recyclerviewbasicsgroupe2.model.President
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val image = findViewById<ImageView>(R.id.imageView2)
        val nom = findViewById<TextView>(R.id.tv_nom_)
        val pays = findViewById<TextView>(R.id.tv_pays_2)
        val biographie = findViewById<TextView>(R.id.biographie)
        val data = intent.getSerializableExtra(PRESIDENT_KEY) as President

        image.setImageResource(data.photo)
        nom.text = data.nom
        pays.text = data.pays
        biographie.text = data.biographie
    }
}