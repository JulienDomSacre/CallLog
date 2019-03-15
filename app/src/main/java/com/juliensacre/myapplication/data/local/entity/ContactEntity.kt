package com.juliensacre.myapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class ContactEntity(
    @PrimaryKey
    val id : Int,
    val name : String,
    @ColumnInfo(name="telephone_number")
    val telNumber : String,
    val service : String,
    val image : String //url
)