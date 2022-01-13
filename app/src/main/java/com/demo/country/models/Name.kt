package com.demo.country.models

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val common: String?,
    val official: String?,
)

@Serializable
data class Flags(
    val png: String?,
    val svg: String?,
)
