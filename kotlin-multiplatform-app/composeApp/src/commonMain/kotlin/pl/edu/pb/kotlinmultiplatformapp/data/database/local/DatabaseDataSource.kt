package pl.edu.pb.kotlinmultiplatformapp.data.database.local

import pl.edu.pb.kotlinmultiplatformapp.data.model.CharacterEntity

interface DatabaseDataSource {

    suspend fun getAllCharacters(): List<CharacterEntity>

    suspend fun saveAllCharacters(characters: List<CharacterEntity>)

    suspend fun clearDatabase()
}
