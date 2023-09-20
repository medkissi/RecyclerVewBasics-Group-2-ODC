package com.medkissi.recyclerviewbasicsgroupe2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medkissi.recyclerviewbasicsgroupe2.data.model.President
import com.medkissi.recyclerviewbasicsgroupe2.data.repository.PresidentRepository

class PresidentViewModel:ViewModel() {
    val repository =PresidentRepository()


    private val _presidents = MutableLiveData<List<President>>()
    val presidents:LiveData<List<President>> = _presidents

    init {
        getData()
    }


    fun getData(){
        _presidents.value= repository.getPresidents()


    }

}