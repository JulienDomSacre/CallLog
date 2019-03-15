package com.juliensacre.myapplication.data.repository

import androidx.lifecycle.LiveData
import com.juliensacre.myapplication.data.local.entity.ContactEntity

interface Repository {
    suspend fun getContacts() : LiveData<List<ContactEntity>>
}