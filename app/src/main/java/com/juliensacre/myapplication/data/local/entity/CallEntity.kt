package com.juliensacre.myapplication.data.local.entity

class CallEntity  (
    id :Int,
    type: String, // todo enum: FAX,SMS,CALL
    date : Long, //timestamp
    from : Int,
    to : Int,
    favourite : Boolean,
    val direction : String, //todo enum
    val callTime : Int, //in seconds
    var answered : Boolean
): LogEntity(id,type,date,from,to,favourite)