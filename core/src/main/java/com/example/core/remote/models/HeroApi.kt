package com.example.core.remote.models

import com.google.gson.annotations.SerializedName

class HeroApi(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("localized_name")
    val localized_name: String,

    @SerializedName("primary_attr")
    val attributes: String,

    @SerializedName("attack_type")
    val attack_type: String,

    @SerializedName("roles")
    val roles: List<String>
){
    constructor() : this(0,"","","","", listOf())
}


