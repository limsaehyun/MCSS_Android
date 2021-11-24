package com.saehyun.mcss.feature.search.viewmodel

import ServerResponse
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.mcss.data.search.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchRepository
    ) : ViewModel() {

    val toastMessage : MutableLiveData<String> = MutableLiveData()
    val serverData: MutableLiveData<ServerResponse> = MutableLiveData()

    fun serverInfo(serverId: String) {
        viewModelScope.launch {
            val response = repository.serverInfo(serverId)

            if(response.isSuccessful) {
                serverData.value = response.body()
                toastMessage.value = "성공" + response.code().toString()
            } else {
                toastMessage.value = "실패"
            }
        }
    }

}