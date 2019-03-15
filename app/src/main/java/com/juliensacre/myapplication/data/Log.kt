package com.juliensacre.myapplication.data

import com.juliensacre.myapplication.data.local.entity.ContactEntity

open class Log (
    val id :Int,
    val type: String, // todo enum: FAX,SMS,CALL
    val date : Long, //timestamp
    val fromContact : ContactEntity, //contact id
    val toContact : ContactEntity, //contact id
    var favourite : Boolean
)