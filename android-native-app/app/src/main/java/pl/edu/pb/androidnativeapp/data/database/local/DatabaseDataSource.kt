package pl.edu.pb.androidnativeapp.data.database.local

import pl.edu.pb.androidnativeapp.data.model.CharacterEntity

interface DatabaseDataSource {

    suspend fun getAllCharacters(): List<CharacterEntity>

    suspend fun saveAllCharacters(characters: List<CharacterEntity>)

    suspend fun clearDatabase()
}
