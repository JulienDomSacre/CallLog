package com.juliensacre.myapplication.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.juliensacre.myapplication.BuildConfig
import com.juliensacre.myapplication.data.local.entity.ContactEntity
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface CallLogAPIService {
    @GET("contactsList/")
    fun getContacts(@Query("user") userId : Int) : Deferred<List<ContactEntity>>

    //Singleton
    companion object {
        //operator fun invoke() <- override the operator () for allows you to initialize the class just with: RickAndMortyApiService()
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor //for di
        ) : CallLogAPIService{
            val okHttpClientBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(connectivityInterceptor) //<- use di for don't have dependency with the context

            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                okHttpClientBuilder.addInterceptor(logging)
            }

            return Retrofit.Builder()
                .baseUrl("https://ringover.com/backend/api/")
                .addConverterFactory(GsonConverterFactory.create()) // use GSon
                .addCallAdapterFactory(CoroutineCallAdapterFactory()) //use coroutine
                .client(okHttpClientBuilder.build()) //add timeout
                .build()
                .create(CallLogAPIService::class.java)
        }
    }
}