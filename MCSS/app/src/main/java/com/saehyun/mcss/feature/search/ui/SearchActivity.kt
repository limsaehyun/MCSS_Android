package com.saehyun.mcss.feature.search.ui

import android.os.Bundle
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseActivity
import com.saehyun.mcss.databinding.ActivitySearchBinding
import com.saehyun.mcss.feature.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : BaseActivity<ActivitySearchBinding>(
    R.layout.activity_search
) {
    val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serverIp = intent.getStringExtra("serverIp")

        showToast(serverIp.toString())

        searchViewModel.serverInfo("Limez.kr")

//        searchViewModel.toastMessage.observe(this, {
//            showToast("${it}")
//        })
    }
}