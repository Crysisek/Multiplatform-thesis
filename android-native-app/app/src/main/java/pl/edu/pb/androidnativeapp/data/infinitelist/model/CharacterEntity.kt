package pl.edu.pb.androidnativeapp.data.infinitelist.model

import com.squareup.moshi.Json

data class CharacterEntity(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "species") val species: String,
    @field:Json(name = "gender") val gender: String,
    @field:Json(name = "image") val image: String,
)
