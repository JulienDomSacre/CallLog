package com.juliensacre.findcar.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juliensacre.myapplication.data.local.CommentDao
import com.juliensacre.myapplication.data.local.entity.CommentEntity
import com.juliensacre.myapplication.data.local.entity.ContactEntity

@Database(
    entities = [ContactEntity::class, CommentEntity::class],
    version = 1
)
abstract class CallLogDatabase: RoomDatabase(){
    abstract fun contactDao() : ContactDao
    abstract fun commentDao() : CommentDao

    //Singleton
    companion object {
        //@Volatile: writes to this field are immediately made visible to other threads.
        @Volatile private var instance: CallLogDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CallLogDatabase::class.java,"car.db")
                .build()
    }
}