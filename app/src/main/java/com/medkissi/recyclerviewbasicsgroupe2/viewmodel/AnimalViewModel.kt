package com.medkissi.recyclerviewbasicsgroupe2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medkissi.recyclerviewbasicsgroupe2.data.model.Animal
import com.medkissi.recyclerviewbasicsgroupe2.data.repository.AnimalRepository

class AnimalViewModel:ViewModel() {

    private val repository:AnimalRepository = AnimalRepository()

    private val _animaux = MutableLiveData<List<Animal>>()
    val animaux:LiveData<List<Animal>> = _animaux


    init {
        getAnimaux()
    }



    fun getAnimaux (){
        _animaux.value = repository.getAnimaux()

    }
}