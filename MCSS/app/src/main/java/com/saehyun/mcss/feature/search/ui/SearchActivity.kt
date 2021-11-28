package com.saehyun.mcss.feature.search.ui

import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import com.bumptech.glide.Glide.with
import com.saehyun.mcss.R
import com.saehyun.mcss.base.BaseActivity
import com.saehyun.mcss.databinding.ActivitySearchBinding
import com.saehyun.mcss.feature.search.viewmodel.SearchViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import android.view.View


class SearchActivity : BaseActivity<ActivitySearchBinding>(
    R.layout.activity_search
) {

    val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serverIp = intent.getStringExtra("server")


        binding.ibSearch.setOnClickListener {
            val serverIp = binding.etSearch.text.toString()

            if(serverIp.isNotEmpty() && serverIp.contains(".")) {
                val intent = Intent(applicationContext, SearchActivity::class.java)
                intent.putExtra("server", serverIp)
                startActivity(intent)
            }
            else {
                showToast("올바른 서버 주소를 입력해주세요.")
            }
        }

        searchViewModel.serverInfo(serverIp.toString())

        searchViewModel.toastMessage.observe(this, {
            showToast("${it}")
        })

        searchViewModel.serverData.observe(this, {
            binding.pb.visibility = View.GONE

            if(it.status == "success") {
                if(!(it.favicon.isNullOrEmpty())) {
                    var encodedDataString: String = it.favicon

                    encodedDataString = encodedDataString.replace("data:image/png;base64,", "")

                    val imageAsBytes: ByteArray = Base64.decode(encodedDataString.toByteArray(), 0)
                    binding.ivServerImage.setImageBitmap(
                        BitmapFactory.decodeByteArray(
                            imageAsBytes, 0, imageAsBytes.size
                        )
                    )
                }

                if(it.online) {
                    binding.ivSearchStatus.setImageResource(R.drawable.ic_online)
                } else {
                    binding.ivSearchStatus.setImageResource(R.drawable.ic_offline)
                }

                var motdLength = it.motd.length

                if(motdLength >= 16 ) {

                }
                binding.tvServerMotd.text = it.motd

                binding.tvServerVersion.text = it.server.name
                binding.tvServerLink.text = serverIp

                binding.tvSearchPersonnel.text = "${it.players.now} / ${it.players.max}"
            } else {
                showToast("도메인 주소가 올바르지 않습니다!")
            }

        })
    }
}