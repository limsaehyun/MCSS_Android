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
        repository.serverInfo(serverId).subscribe { response ->
            if(response.isSuccessful) {
                serverData.value = response.body()
            } else {
                toastMessage.value = "error!"
            }
        }
    }

}