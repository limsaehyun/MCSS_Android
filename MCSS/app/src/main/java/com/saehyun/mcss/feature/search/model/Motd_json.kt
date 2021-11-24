import com.google.gson.annotations.SerializedName

data class Motd_json (

	@SerializedName("extra") val extra : List<Extra>,
	@SerializedName("text") val text : String
)