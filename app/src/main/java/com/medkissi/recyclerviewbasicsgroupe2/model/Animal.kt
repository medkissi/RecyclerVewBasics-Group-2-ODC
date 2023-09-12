package com.medkissi.recyclerviewbasicsgroupe2.model

import com.medkissi.recyclerviewbasicsgroupe2.R
import java.io.Serializable

class Animal(
    val nom:String,
    val vitesse:Int,
    val image:Int
):Serializable

val animaux = listOf<Animal>(
    Animal("Lion",60, R.drawable.lion),
    Animal("Tigre",84,R.drawable.tigre),
    Animal("Lynx",30,R.drawable.lynx),
    Animal("Chat",20,R.drawable.chat),
    Animal("Cougar",20,R.drawable.cougar),
    Animal("Jaguar",90,R.drawable.jaguar),
    Animal("Leopard",90,R.drawable.leopard),
)