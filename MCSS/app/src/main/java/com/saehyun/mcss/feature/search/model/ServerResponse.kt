import com.google.gson.annotations.SerializedName

data class ServerResponse (

	@SerializedName("status") val status : String,
	@SerializedName("online") val online : Boolean,
	@SerializedName("motd") val motd : String,
	@SerializedName("motd_json") val motd_json : Motd_json,
	@SerializedName("favicon") val favicon : String,
	@SerializedName("error") val error : String,
	@SerializedName("players") val players : Players,
	@SerializedName("server") val server : Server,
	@SerializedName("last_updated") val last_updated : Int,
	@SerializedName("duration") val duration : Int
)