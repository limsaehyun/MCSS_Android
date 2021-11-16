import com.google.gson.annotations.SerializedName
import com.saehyun.mcss.model.data.*

data class McsrvstatusResponse (
	@SerializedName("online")val online : Boolean,
	@SerializedName("ip") val ip : String,
	@SerializedName("port") val port : Int,
	@SerializedName("debug") val debug : Debug,
	@SerializedName("motd") val motd : Motd,
	@SerializedName("players") val players : Players,
	@SerializedName("version") val version : Double,
	@SerializedName("protocol") val protocol : Int,
	@SerializedName("hostname") val hostname : String,
	@SerializedName("icon") val icon : String,
	@SerializedName("software") val software : String,
	@SerializedName("map") val map : String,
	@SerializedName("gamemode") val gamemode : String,
	@SerializedName("serverid") val serverid : Int,
	@SerializedName("plugins") val plugins : Plugins,
	@SerializedName("mods") val mods : Mods,
	@SerializedName("info") val info : Info
)