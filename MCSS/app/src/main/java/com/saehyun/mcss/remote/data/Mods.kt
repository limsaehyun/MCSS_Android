package com.saehyun.mcss.remote.data

import com.google.gson.annotations.SerializedName

data class Mods (

	@SerializedName("names") val names : List<String>,
	@SerializedName("raw") val raw : List<String>
)