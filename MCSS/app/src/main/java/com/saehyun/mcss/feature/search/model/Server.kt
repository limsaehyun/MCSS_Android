import com.google.gson.annotations.SerializedName

data class Server (

	@SerializedName("name") val name : String,
	@SerializedName("protocol") val protocol : Int
)