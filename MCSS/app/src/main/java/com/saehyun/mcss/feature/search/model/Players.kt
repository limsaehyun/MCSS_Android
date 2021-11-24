import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.saehyun.mcss.feature.search.model.User

data class Players (

	@SerializedName("max") val max : Int,
	@SerializedName("now") val now : Int,
	@SerializedName("sample") val sample : List<User>
)