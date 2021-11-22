package com.saehyun.mcss.remote.data

import com.google.gson.annotations.SerializedName

data class Players (

	@SerializedName("online") val online : Int,
	@SerializedName("max") val max : Int,
	@SerializedName("list") val list : List<String>,
	@SerializedName("uuid") val uuid : Uuid
)