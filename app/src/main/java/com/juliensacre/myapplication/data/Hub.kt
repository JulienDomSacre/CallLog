package com.juliensacre.myapplication.data

data class Hub(
    val missedCall : Int,
    val voicemail : Int,
    val sms : Int,
    val logs : List<Log>
)