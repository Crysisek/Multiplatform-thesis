package pl.edu.pb.kotlinmultiplatformapp.data.database.repository

import pl.edu.pb.kotlinmultiplatformapp.model.Character

interface DatabaseRepository {

    suspend fun getAllCharacters(): List<Character>

    suspend fun saveAllCharacters()

    suspend fun clearDatabase()
}
