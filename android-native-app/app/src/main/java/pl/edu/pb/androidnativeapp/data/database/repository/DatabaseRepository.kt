package pl.edu.pb.androidnativeapp.data.database.repository

import pl.edu.pb.androidnativeapp.model.Character
import pl.edu.pb.androidnativeapp.model.Characters

interface DatabaseRepository {

    suspend fun getAllCharacters(): List<Character>

    suspend fun saveAllCharacters()

    suspend fun clearDatabase()
}
