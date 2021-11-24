package com.saehyun.mcss.data.search

import ServerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchApi {
    
    @GET("server/status")
    suspend fun serverInfo(
        @Query("ip") serverIp: String
    ) : Response<ServerResponse>

}