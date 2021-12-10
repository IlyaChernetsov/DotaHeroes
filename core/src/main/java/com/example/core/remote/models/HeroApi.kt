package com.example.core.remote.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class HeroApi(
    val id: Int,
    val name: String,
    val localized_name: String,
    val attributes: String,
    val attack_type: String,
    val roles: List<String>
)

