import com.google.gson.annotations.SerializedName


data class CharacterResponseModel(

    @SerializedName("request_hash")
    val request_hash: String,

    @SerializedName("request_cached")
    val request_cached: Boolean,

    @SerializedName("request_cache_expiry")
    val request_cache_expiry: Int,

    @SerializedName("characters")
    val characters: List<Characters>,
)