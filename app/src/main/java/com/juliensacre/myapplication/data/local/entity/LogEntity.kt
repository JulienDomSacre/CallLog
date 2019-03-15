package com.juliensacre.myapplication.data.local.entity

import androidx.room.PrimaryKey

open class LogEntity (
    @PrimaryKey
    val id :Int,
    val type: String, // todo enum: FAX,SMS,CALL
    val date : Long, //timestamp
    val fromContact : Int, //contact id
    val toContact : Int, //contact id
    var favourite : Boolean
)