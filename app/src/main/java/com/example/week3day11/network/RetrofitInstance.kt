package com.example.week3day11.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import kotlin.jvm.Throws

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private var mClient: OkHttpClient? = null
    private val client: OkHttpClient
    @Throws(NoSuchAlgorithmException::class,KeyManagementException::class)
    get(){
        if (mClient == null){
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val httpBuilder = OkHttpClient.Builder()
            mClient = httpBuilder.build()
        }
        return mClient!!

    }
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}