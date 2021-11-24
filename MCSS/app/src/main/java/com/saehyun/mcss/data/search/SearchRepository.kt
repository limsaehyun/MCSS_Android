package com.saehyun.mcss.data.search

import ServerResponse
import com.saehyun.mcss.data.searchApi
import retrofit2.Response

class SearchRepository {

    suspend fun serverInfo(serverIp: String) : Response<ServerResponse> {
        return searchApi.serverInfo(serverIp)
    }

}