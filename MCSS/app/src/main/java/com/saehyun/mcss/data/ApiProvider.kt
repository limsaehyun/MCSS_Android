package com.saehyun.mcss.data

import MC_BASE_URL
import com.saehyun.mcss.data.search.SearchApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(MC_BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val searchApi : SearchApi by lazy {
    retrofit.create(SearchApi::class.java)
}