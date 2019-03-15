package com.juliensacre.myapplication.data

import com.juliensacre.myapplication.data.local.entity.ContactEntity

class Call (
    id :Int,
    type: String, // todo enum: FAX,SMS,CALL
    date : Long, //timestamp
    from : ContactEntity,
    to : ContactEntity,
    favourite : Boolean,
    val direction : String, //todo enum
    val callTime : Int, //in seconds
    var answered : Boolean
): Log(id,type,date,from,to,favourite)
