package com.example.core.remote.models

import kotlinx.serialization.Serializable

@Serializable
class HeroApi(
    val id: Int,
    val name: String,
    val primary_attr: String,
    val attack_type: String,
    val roles: List<String>
)

