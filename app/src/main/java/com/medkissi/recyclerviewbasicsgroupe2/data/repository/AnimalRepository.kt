package com.medkissi.recyclerviewbasicsgroupe2.data.repository

import com.medkissi.recyclerviewbasicsgroupe2.data.datasource.AnimalDataSource
import com.medkissi.recyclerviewbasicsgroupe2.data.model.Animal

class AnimalRepository {
    private val animalDataSource =AnimalDataSource()

    fun getAnimaux():List<Animal>{

        return animalDataSource.animaux
    }

}