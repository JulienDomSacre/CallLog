package com.juliensacre.myapplication.data.local.entity

class MessageEntity(
    id :Int,
    type: String, // todo enum: FAX,SMS,CALL
    date : Long, //timestamp
    from : Int,
    to : Int,
    favourite : Boolean,
    val text : String
):LogEntity(id,type,date,from,to,favourite)