package com.saehyun.mcss.data.search

import com.saehyun.mcss.feature.search.model.McsrvstatusResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchApi {
    
    @GET("2/{server-ip}")
    suspend fun serverInfo(
        @Path("server-ip") serverIp: String
    ) : Response<McsrvstatusResponse>

}