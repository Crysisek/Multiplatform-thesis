package pl.edu.pb.kotlinmultiplatformapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Page(
    @SerialName("info") val info: Info,
    @SerialName("results") val results: List<CharacterEntity>,
) {
    @Serializable
    data class Info(
        @SerialName("count") val count: Int?,
        @SerialName("pages") val pages: Int?,
        @SerialName("next") val next: String?,
        @SerialName("prev") val prev: String?,
    )
}
