package com.saehyun.mcss.feature.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseFragment
import com.saehyun.mcss.databinding.FragmentHomeBinding
import com.saehyun.mcss.feature.bookmark.BookMarkData
import com.saehyun.mcss.feature.bookmark.CustomDialog
import com.saehyun.mcss.feature.bookmark.MainAdapter
import com.saehyun.mcss.feature.search.ui.SearchActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home
) {

    private var bookMarkData = arrayListOf<BookMarkData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.run {
            ibMainSearch.setOnClickListener {
                val serverIp = imageView.text.toString()

                if(serverIp.isNotEmpty() && serverIp.contains(".")) {
                    val intent = Intent(context, SearchActivity::class.java)
                    intent.putExtra("server", serverIp)
                    startActivity(intent)
                }
                else {
                    showToast("올바른 서버 주소를 입력해주세요.")
                }
            }

            rvMainBookMark.layoutManager= GridLayoutManager(context, 2)
            rvMainBookMark.setHasFixedSize(true)
            rvMainBookMark.adapter= context?.let { MainAdapter(it, bookMarkData) }

            ibBookMark.setOnClickListener {
                var hname: String = "default"
                var hdomain: String = "default"

                CustomDialog(requireContext()).run {
                    name.observe(viewLifecycleOwner, {
                        hname = it
                    })
                    domain.observe(viewLifecycleOwner, {
                        hdomain = it
                    })
                    success.observe(viewLifecycleOwner, {
                        bookMarkData.add(BookMarkData(hname, hdomain))

                        rvMainBookMark.adapter?.notifyDataSetChanged()
                    })
                    start()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        binding.rvMainBookMark.adapter?.notifyDataSetChanged()
    }

    override fun observeEvent() {}
}