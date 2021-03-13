import com.google.gson.annotations.SerializedName


data class Characters(

    @SerializedName("mal_id")
    val mal_id: Int,

    @SerializedName("url")
    val url: String,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("role")
    val role: String,
)