package com.saehyun.mcss.model.data

import com.google.gson.annotations.SerializedName

data class Info (

	@SerializedName("raw") val raw : List<String>,
	@SerializedName("clean") val clean : List<String>,
	@SerializedName("html") val html : List<String>
)