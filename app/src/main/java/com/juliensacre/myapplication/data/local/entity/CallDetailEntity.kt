package com.juliensacre.myapplication.data.local.entity

data class CallDetailEntity (
    val person : ContactEntity,
    val transfersCall : List<Int>, //callId
    val historyCall: List<Int>, //callHistoryId
    val comments : List<Int> //commentsId
)