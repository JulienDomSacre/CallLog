package com.juliensacre.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.juliensacre.myapplication.data.local.entity.CommentEntity

@Dao
interface CommentDao {
    //update and insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(comment : CommentEntity)

    @Query("select * from comment where id in(:listOfIds)")
    fun getComments(listOfIds : List<Int>) : LiveData<List<CommentEntity>>

    @Query("select * from comment where id = :id")
    fun getContact(id : Int) : LiveData<CommentEntity>

    @Delete
    fun deleteContact (comment: CommentEntity)
}