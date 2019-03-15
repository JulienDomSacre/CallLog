package com.juliensacre.myapplication.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "comment", foreignKeys = arrayOf(
    ForeignKey(entity = ContactEntity::class, parentColumns = arrayOf("id"), childColumns = arrayOf("createdBy"))
))
data class CommentEntity (
    @PrimaryKey
    val id : Int,
    val date : Long, //timestamp
    val createdBy : Int,
    val text : String
)