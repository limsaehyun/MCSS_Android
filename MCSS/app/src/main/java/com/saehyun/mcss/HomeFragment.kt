package com.saehyun.mcss

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseFragment
import com.saehyun.mcss.databinding.FragmentHomeBinding
import com.saehyun.mcss.feature.search.viewmodel.SearchViewModel
import com.saehyun.mcss.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home
) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.textHome.text = "테스트"

        return binding.root
    }
}