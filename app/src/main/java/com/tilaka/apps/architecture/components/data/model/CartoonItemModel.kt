package com.tilaka.apps.architecture.components.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
data class CartoonItemModel(
    @SerializedName("mal_id")
    @Expose
    var malId: Int? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("airing")
    @Expose
    var airing: Boolean? = null,

    @SerializedName("synopsis")
    @Expose
    var synopsis: String? = null,

    @SerializedName("type")
    @Expose
    var type: String? = null,

    @SerializedName("episodes")
    @Expose
    var episodes: Int? = null,

    @SerializedName("score")
    @Expose
    var score: Double? = null,

    @SerializedName("start_date")
    @Expose
    var startDate: Date? = null,

    @SerializedName("end_date")
    @Expose
    var endDate: Date? = null,

    @SerializedName("members")
    @Expose
    var members: Int? = null,

    @SerializedName("rated")
    @Expose
    var rated: String? = null,
) : Parcelable {
    override fun toString(): String {
        return "CartoonItemModel(malId=$malId," +
                "\n url=$url," +
                "\n imageUrl=$imageUrl," +
                "\n title=$title," +
                "\n airing=$airing," +
                "\n synopsis=$synopsis," +
                "\n type=$type," +
                "\n episodes=$episodes," +
                "\n score=$score," +
                "\n startDate=$startDate," +
                "\n endDate=$endDate," +
                "\n members=$members," +
                "\n rated=$rated)"
    }


}