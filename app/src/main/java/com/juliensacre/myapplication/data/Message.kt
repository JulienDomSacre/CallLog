package com.juliensacre.myapplication.data

import com.juliensacre.myapplication.data.local.entity.ContactEntity

class Message(
    id :Int,
    type: String, // todo enum: FAX,SMS,CALL
    date : Long, //timestamp
    from : ContactEntity,
    to : ContactEntity,
    favourite : Boolean,
    val text : String
):Log(id,type,date,from,to,favourite)