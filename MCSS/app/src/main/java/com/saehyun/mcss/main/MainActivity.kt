package com.saehyun.mcss.main

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseActivity
import com.saehyun.mcss.databinding.ActivityMainBinding
import com.saehyun.mcss.feature.bookmark.BookMarkData
import com.saehyun.mcss.feature.bookmark.CustomDialog
import com.saehyun.mcss.feature.bookmark.MainAdapter
import com.saehyun.mcss.feature.search.ui.SearchActivity

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    private var bookMarkData = arrayListOf<BookMarkData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.ibMainSearch.setOnClickListener {
            val serverIp = binding.imageView.text.toString()

            if(serverIp.isNotEmpty() && serverIp.contains(".")) {
                val intent = Intent(applicationContext, SearchActivity::class.java)
                intent.putExtra("server", serverIp)
                startActivity(intent)
            }
            else {
                showToast("올바른 서버 주소를 입력해주세요.")
            }
        }

        binding.rvMainBookMark.layoutManager= GridLayoutManager(this, 2)
        binding.rvMainBookMark.setHasFixedSize(true)
        binding.rvMainBookMark.adapter= MainAdapter(applicationContext, bookMarkData)

        binding.ibBookMark.setOnClickListener {
            var name: String = "default"
            var domain: String = "default"

            val dlg = CustomDialog(this)

            dlg.name.observe(this, {
                name = it
            })
            dlg.domain.observe(this, {
                domain = it
            })
            dlg.success.observe(this, {
                bookMarkData.add(BookMarkData(name, domain))

                binding.rvMainBookMark.adapter?.notifyDataSetChanged()
            })

            dlg.start()
        }

    }

    override fun onResume() {
        super.onResume()

        binding.rvMainBookMark.adapter?.notifyDataSetChanged()
    }
}