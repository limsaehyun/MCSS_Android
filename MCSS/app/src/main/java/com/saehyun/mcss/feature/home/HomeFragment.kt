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
import com.saehyun.mcss.databinding.FragmentHomeBinding
import com.saehyun.mcss.feature.bookmark.BookMarkData
import com.saehyun.mcss.feature.bookmark.CustomDialog
import com.saehyun.mcss.feature.bookmark.MainAdapter
import com.saehyun.mcss.feature.search.ui.SearchActivity

class HomeFragment : Fragment() {

    private var bookMarkData = arrayListOf<BookMarkData>()
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.ibMainSearch.setOnClickListener {
            val serverIp = binding.imageView.text.toString()

            if(serverIp.isNotEmpty() && serverIp.contains(".")) {
                val intent = Intent(context, SearchActivity::class.java)
                intent.putExtra("server", serverIp)
                startActivity(intent)
            }
            else {
                Toast.makeText(context, "올바른 서버 주소를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.rvMainBookMark.layoutManager= GridLayoutManager(context, 2)
        binding.rvMainBookMark.setHasFixedSize(true)
        binding.rvMainBookMark.adapter= context?.let { MainAdapter(it, bookMarkData) }

        binding.ibBookMark.setOnClickListener {
            var name: String = "default"
            var domain: String = "default"

            val dlg = context?.let { it1 -> CustomDialog(it1) }!!

            dlg.name.observe(viewLifecycleOwner, {
                name = it
            })
            dlg.domain.observe(viewLifecycleOwner, {
                domain = it
            })
            dlg.success.observe(viewLifecycleOwner, {
                bookMarkData.add(BookMarkData(name, domain))

                binding.rvMainBookMark.adapter?.notifyDataSetChanged()
            })

            dlg.start()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.rvMainBookMark.adapter?.notifyDataSetChanged()
    }
}