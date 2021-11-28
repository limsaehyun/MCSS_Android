package com.saehyun.mcss.data.search

import ServerResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    
    @GET("server/status")
    fun serverInfo(
        @Query("ip") serverIp: String
    ) : Single<Response<ServerResponse>>

}