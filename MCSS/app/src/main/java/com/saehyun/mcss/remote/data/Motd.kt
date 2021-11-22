package com.saehyun.mcss.remote.data

import com.google.gson.annotations.SerializedName

data class Motd (

	@SerializedName("raw") val raw : List<String>,
	@SerializedName("clean") val clean : List<String>,
	@SerializedName("html") val html : List<String>
)