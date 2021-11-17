package com.saehyun.mcss.model.data

import com.google.gson.annotations.SerializedName

data class Plugins (

	@SerializedName("names") val names : List<String>,
	@SerializedName("raw") val raw : List<String>
)