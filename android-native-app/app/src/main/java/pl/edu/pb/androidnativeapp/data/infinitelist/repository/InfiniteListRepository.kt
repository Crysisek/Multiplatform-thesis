package pl.edu.pb.androidnativeapp.data.infinitelist.repository

import pl.edu.pb.androidnativeapp.model.Character
import pl.edu.pb.androidnativeapp.model.Characters

interface InfiniteListRepository {

    suspend fun getCharacters(url: String): Characters

    suspend fun getAllCharacters(): List<Character>
}
