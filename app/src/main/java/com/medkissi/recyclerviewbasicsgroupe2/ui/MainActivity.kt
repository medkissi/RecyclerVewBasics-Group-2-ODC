package com.medkissi.recyclerviewbasicsgroupe2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medkissi.recyclerviewbasicsgroupe2.adapters.AnimalAdapter
import com.medkissi.recyclerviewbasicsgroupe2.adapters.OnAnimalClickListner
import com.medkissi.recyclerviewbasicsgroupe2.R
import com.medkissi.recyclerviewbasicsgroupe2.data.model.Animal
import com.medkissi.recyclerviewbasicsgroupe2.viewmodel.AnimalViewModel

const val ANIMAL_KEY ="animal"

class MainActivity : AppCompatActivity(), OnAnimalClickListner {
    lateinit var adapter: AnimalAdapter
    val viewModel:AnimalViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rv2)

        viewModel.animaux.observe(this){ animaux ->
            adapter =AnimalAdapter(animaux,this )
            recyclerView.adapter = adapter

        }
        // Creation de notre adapter
        // creation de notre LayoutManager qui est responsable de la disposition des elements de notre liste
        val layoutManager = LinearLayoutManager(this )
        // ici on attache notre layoutManager a notre RecycleView
        recyclerView.layoutManager = layoutManager
        //
        // Ici on attache notre adapter a notre RecylerView
        //recyclerView.adapter = adapter
    }

    override fun onClick(animal: Animal) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(ANIMAL_KEY,animal)
        startActivity(intent)

    }


}