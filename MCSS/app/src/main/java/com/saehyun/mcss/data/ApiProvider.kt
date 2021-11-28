package com.saehyun.mcss.data

import MC_BASE_URL
import com.saehyun.mcss.data.search.SearchApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl(MC_BASE_URL)
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    addConverterFactory(GsonConverterFactory.create())
}.build()

val searchApi : SearchApi by lazy {
    retrofit.create(SearchApi::class.java)
}