package com.saehyun.mcss.feature.search.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.mcss.data.search.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: SearchRepository
    ) : ViewModel() {

    val toastMessage : MutableLiveData<String> = MutableLiveData()

    fun serverInfo(serverId: String) {
        viewModelScope.launch {
            val response = repository.serverInfo(serverId)

            if(response.isSuccessful) {
                toastMessage.value = "성공"
            } else {
                toastMessage.value = "실패"
            }
        }
    }

}