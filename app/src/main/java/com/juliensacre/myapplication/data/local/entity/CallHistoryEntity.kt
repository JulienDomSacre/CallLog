package com.juliensacre.myapplication.data.local.entity

data class CallHistoryEntity (
    val id : Int,
    val date : Long, // timestamp
    val direction : String, //todo enum or boolean
    val callTime : Int //in seconds
)