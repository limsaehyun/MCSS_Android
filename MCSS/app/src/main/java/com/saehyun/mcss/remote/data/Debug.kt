package com.saehyun.mcss.remote.data

import com.google.gson.annotations.SerializedName

data class Debug (

	@SerializedName("ping") val ping : Boolean,
	@SerializedName("query") val query : Boolean,
	@SerializedName("srv") val srv : Boolean,
	@SerializedName("querymismatch") val querymismatch : Boolean,
	@SerializedName("ipinsrv") val ipinsrv : Boolean,
	@SerializedName("cnameinsrv") val cnameinsrv : Boolean,
	@SerializedName("animatedmotd") val animatedmotd : Boolean,
	@SerializedName("cachetime") val cachetime : Int
)