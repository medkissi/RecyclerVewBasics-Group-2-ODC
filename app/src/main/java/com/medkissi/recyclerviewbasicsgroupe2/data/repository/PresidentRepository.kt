package com.medkissi.recyclerviewbasicsgroupe2.data.repository

import com.medkissi.recyclerviewbasicsgroupe2.data.datasource.PresidentDataSource
import com.medkissi.recyclerviewbasicsgroupe2.data.model.President

class PresidentRepository {
    private val presidentDataSource = PresidentDataSource()

    fun getPresidents():List<President>{
        return presidentDataSource.presidents
    }
}