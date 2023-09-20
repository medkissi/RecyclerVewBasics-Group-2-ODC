package com.medkissi.recyclerviewbasicsgroupe2.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.medkissi.recyclerviewbasicsgroupe2.adapters.OnItemClickListner
import com.medkissi.recyclerviewbasicsgroupe2.adapters.PresidentAdapter
import com.medkissi.recyclerviewbasicsgroupe2.R
import com.medkissi.recyclerviewbasicsgroupe2.data.model.President
import com.medkissi.recyclerviewbasicsgroupe2.viewmodel.PresidentViewModel

const val PRESIDENT_KEY = "president"

class PresidentActivity : AppCompatActivity(), OnItemClickListner {
    val viewModel: PresidentViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_president)
        val toolbar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer)

        toolbar.setNavigationOnClickListener {
            drawer.open()
        }
        val navView = findViewById<NavigationView>(R.id.navigationView)
        navView.setNavigationItemSelectedListener { item ->
            if (item.itemId == R.id.home) {
                Toast.makeText(this,"Vous avez cliqué sur Accueil ",Toast.LENGTH_SHORT).show()

                drawer.close()

            }
            if (item.itemId == R.id.about1){
                Toast.makeText(this,"Vous avez cliqué sur Apropos ",Toast.LENGTH_SHORT).show()
                drawer.close()

            }
            true

        }


        val recyclerView = findViewById<RecyclerView>(R.id.rv2)
        val adapter = PresidentAdapter(this)

        val linearLayoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        viewModel.presidents.observe(this) { data ->
            adapter.submitList(data)

        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.parametre) {
            Toast.makeText(this, "Paramètres", Toast.LENGTH_SHORT).show()
        }
        if (item.itemId == R.id.about1) {
            Toast.makeText(this, "A propos", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onClick(president: President) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(PRESIDENT_KEY, president)
        startActivity(intent)
    }
}
