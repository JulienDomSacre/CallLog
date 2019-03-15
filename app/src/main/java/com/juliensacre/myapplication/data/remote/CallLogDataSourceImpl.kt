package com.juliensacre.myapplication.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.juliensacre.myapplication.data.local.entity.ContactEntity
import com.juliensacre.myapplication.internal.NoConnectivityException

class CallLogDataSourceImpl(
    private val callLogAPIService: CallLogAPIService
) : CallLogDataSource {
    // use this because liveData is not mutable but i doesn't want to share a mutable data
    private val _downloadedContacts = MutableLiveData<List<ContactEntity>>()
    override val downloadedContacts: LiveData<List<ContactEntity>>
        get() = _downloadedContacts // automatic cast on LiveData

    override suspend fun fetchContactList() {
        try {
            //TODO replace userId by the one connected, find it in shared preference later
            val fetchedContactList = callLogAPIService.getContacts(17336).await()
            _downloadedContacts.postValue(fetchedContactList)
        }catch (e: NoConnectivityException){
            Log.e("connectivity", "No internet connection",e)
        }
    }
}