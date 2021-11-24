package com.saehyun.mcss.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseActivity
import com.saehyun.mcss.databinding.ActivityMainBinding
import com.saehyun.mcss.feature.search.ui.SearchActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
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
    }

}