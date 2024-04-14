package pl.edu.pb.androidnativeapp.data.model

import com.squareup.moshi.Json

data class Page(
    @field:Json(name = "info") val info: Info,
    @field:Json(name = "results") val results: List<CharacterEntity>,
) {
    data class Info(
        @field:Json(name = "count") val count: Int?,
        @field:Json(name = "pages") val pages: Int?,
        @field:Json(name = "next") val next: String?,
        @field:Json(name = "prev") val prev: String?,
    )
}
