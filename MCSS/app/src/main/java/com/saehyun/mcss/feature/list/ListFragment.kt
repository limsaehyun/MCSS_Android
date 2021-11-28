package com.saehyun.mcss.feature.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseFragment
import com.saehyun.mcss.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding>(
    R.layout.fragment_list
) {


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        initView()
    }

    private fun initView() {
        binding.wvList.webViewClient = WebViewClient()
        binding.wvList.loadUrl("https://minelist.kr")
    }

    override fun observeEvent() {}
}