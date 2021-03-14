package com.tilaka.apps.architecture.components.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimeItem(
    @SerializedName("mal_id")
    val mal_id: Int? = 0,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("image_url")
    val image_url: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("airing")
    val airing: Boolean? = false,

    @SerializedName("synopsis")
    val synopsis: String? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("episodes")
    val episodes: Int? = 0,

    @SerializedName("score")
    val score: Double? = 0.0,

    @SerializedName("start_date")
    val start_date: String? = null,

    @SerializedName("end_date")
    val end_date: String? = null,

    @SerializedName("members")
    val members: String? = null,

    @SerializedName("rated")
    val rated: String? = null
): Parcelable