package com.juliensacre.myapplication.data.remote

import androidx.lifecycle.LiveData
import com.juliensacre.myapplication.data.local.entity.ContactEntity

interface CallLogDataSource {

    val downloadedContacts: LiveData<List<ContactEntity>>

    suspend fun fetchContactList()
}