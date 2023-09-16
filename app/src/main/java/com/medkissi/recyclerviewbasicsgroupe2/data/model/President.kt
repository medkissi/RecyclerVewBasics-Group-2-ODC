package com.medkissi.recyclerviewbasicsgroupe2.data.model

import com.medkissi.recyclerviewbasicsgroupe2.R
import java.io.Serializable

data class President (
    val id:Int,
    val nom:String,
    val pays:String,
    val photo:Int,
    val biographie:String
):Serializable


