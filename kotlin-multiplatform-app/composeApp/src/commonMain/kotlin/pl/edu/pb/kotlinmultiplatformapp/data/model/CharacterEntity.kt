package pl.edu.pb.kotlinmultiplatformapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterEntity(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status") val status: String,
    @SerialName("species") val species: String,
    @SerialName("gender") val gender: String,
    @SerialName("image") val image: String,
)
