package com.juliensacre.myapplication.data.repository

import androidx.lifecycle.LiveData
import com.juliensacre.findcar.data.local.ContactDao
import com.juliensacre.myapplication.data.local.entity.ContactEntity
import com.juliensacre.myapplication.data.remote.CallLogDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val callLogDataSource: CallLogDataSource,
    private val contactDao: ContactDao
) : Repository {
    init {
        //observeForever: because the repository doesn't have a lifecycle,
        // and when this repo being destroyed because the whole app is destroyed, the lifecycle doesn't
        // have a role in this observer
        callLogDataSource.downloadedContacts.observeForever { newContacts ->
            persistFetchedContacts(newContacts)
        }
    }
    override suspend fun getContacts(): LiveData<List<ContactEntity>> {
        //use withContext because is return a result, GolbalScope doesn't
        return withContext(Dispatchers.IO){
            return@withContext contactDao.getContacts()
        }
    }

    private fun persistFetchedContacts(fetchedContacts: List<ContactEntity>){
        //use IO for don't depend of lifecycle of the app
        GlobalScope.launch(Dispatchers.IO) {
            contactDao.upserts(fetchedContacts)
        }
    }

    //doesn't want return because the result of this call is directly send to the observeForever
    private suspend fun initCarData(){
        callLogDataSource.fetchContactList()
    }
}