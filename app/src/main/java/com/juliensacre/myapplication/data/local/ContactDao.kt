package com.juliensacre.findcar.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.juliensacre.myapplication.data.local.entity.ContactEntity

@Dao
interface ContactDao {
    //update and insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(contact : ContactEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upserts(contacts : List<ContactEntity>)

    @Query("select * from contact")
    fun getContacts() : LiveData<List<ContactEntity>>

    @Query("select * from contact where id in(:listOfIds)")
    fun getContactsById(listOfIds: List<Int>) : LiveData<List<ContactEntity>>

    @Query("select * from contact where id = :id")
    fun getContact(id : Int) : LiveData<ContactEntity>

    @Delete
    fun deleteContact (contact: ContactEntity)
}