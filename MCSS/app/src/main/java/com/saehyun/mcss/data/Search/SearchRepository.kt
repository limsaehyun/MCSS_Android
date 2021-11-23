package com.saehyun.mcss.data.Search

import com.saehyun.mcss.data.searchApi
import com.saehyun.mcss.feature.search.model.McsrvstatusResponse
import retrofit2.Response

class SearchRepository {

    suspend fun serverInfo(serverIp: String) : Response<McsrvstatusResponse> {
        return searchApi.serverInfo(serverIp)
    }

}