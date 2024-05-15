package pl.edu.pb.kotlinmultiplatformapp.data.infinitelist.repository

import pl.edu.pb.kotlinmultiplatformapp.model.Character
import pl.edu.pb.kotlinmultiplatformapp.model.Characters

interface InfiniteListRepository {

    suspend fun getCharacters(url: String): Characters

    suspend fun getAllCharacters(): List<Character>
}
