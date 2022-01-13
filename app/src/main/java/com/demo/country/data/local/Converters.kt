package com.demo.country.data.local

import androidx.room.TypeConverter
import com.demo.country.models.Flags
import com.demo.country.models.Name
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {


    @TypeConverter
    fun fromList(value: List<String>?) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<String>?>(value.toString())

    @TypeConverter
    fun fromName(value: Name) = Json.encodeToString(value)

    @TypeConverter
    fun toName(value: String) = Json.decodeFromString<Name>(value)

    @TypeConverter
    fun fromFlag(value: Flags) = Json.encodeToString(value)

    @TypeConverter
    fun toFlag(value: String) = Json.decodeFromString<Flags>(value)

    @TypeConverter
    fun fromMap(value: HashMap<String, String>) = Json.encodeToString(value)

    @TypeConverter
    fun toMap(value: String) = Json.decodeFromString<HashMap<String, String>>(value)


}