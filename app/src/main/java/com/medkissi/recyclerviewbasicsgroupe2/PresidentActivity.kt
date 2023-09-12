package com.medkissi.recyclerviewbasicsgroupe2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.medkissi.recyclerviewbasicsgroupe2.model.President
import com.medkissi.recyclerviewbasicsgroupe2.model.presidents

const val PRESIDENT_KEY = "president"

class PresidentActivity : AppCompatActivity(), OnItemClickListner {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_president)

        val recyclerView = findViewById<RecyclerView>(R.id.rv2)
        val adapter = PresidentAdapter(this)

        val linearLayoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        adapter.submitList(presidents)


    }
override fun onClick(president: President) {
    val intent = Intent(this, DetailActivity::class.java)
    intent.putExtra(PRESIDENT_KEY, president)
    startActivity(intent)
}
}
