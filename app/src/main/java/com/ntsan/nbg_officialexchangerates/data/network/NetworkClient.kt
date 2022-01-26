package com.ntsan.nbg_officialexchangerates.data.network

import com.ntsan.nbg_officialexchangerates.data.models.NBGCurrencyData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkClient {

    val nbgService by lazy { createNBGService() }

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun createNBGService(): NBGCurrencyData {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl("https://nbg.gov.ge/gw/api/ct/monetarypolicy/currencies/ka/json")
        retrofitBuilder.client(
            OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        )
        retrofitBuilder.addConverterFactory(moshiConverter())
        return retrofitBuilder.build().create(NBGCurrencyData::class.java)
    }

    private fun moshiConverter() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )

}