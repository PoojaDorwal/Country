package com.demo.country.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "country")
data class Country(
    @PrimaryKey

    @SerializedName("cca2")
    val id: String,

    val name: Name?,
    val capital: List<String>? = ArrayList(),
    val region: String?,

    @SerializedName("subregion")
    val subRegion: String?,

    val languages: HashMap<String, String>?,
    val borders: List<String>? = ArrayList(),
    val flags: Flags?,
    val population: Long?,
) {
    @Ignore
    val capitalsString = capital?.joinToString(", ")
    @Ignore
    val bordersString = borders?.joinToString(", ")
    @Ignore
    val languagesString = languages?.values?.joinToString(", ")
}

