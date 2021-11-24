import com.google.gson.annotations.SerializedName

data class Extra (
	@SerializedName("color") val color : String,
	@SerializedName("text") val text : String
)