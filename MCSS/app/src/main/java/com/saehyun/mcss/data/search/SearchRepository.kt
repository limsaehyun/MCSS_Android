package com.saehyun.mcss.data.search

import ServerResponse
import com.saehyun.mcss.data.searchApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class SearchRepository {

    fun serverInfo(serverIp: String) : @NonNull Single<Response<ServerResponse>> =
        searchApi.serverInfo(serverIp)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}