package pl.edu.pb.kotlinmultiplatformapp.data.database.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import pl.edu.pb.kotlinmultiplatformapp.data.database.CharacterDatabase
import pl.edu.pb.kotlinmultiplatformapp.data.database.DatabaseDriverFactory
import pl.edu.pb.kotlinmultiplatformapp.data.model.CharacterEntity

class DatabaseDataSourceImpl(
    databaseDriverFactory: DatabaseDriverFactory,
) : DatabaseDataSource {

    private val database = CharacterDatabase(databaseDriverFactory)

    override suspend fun getAllCharacters(): List<CharacterEntity> {
        return withContext(Dispatchers.IO) {
            database.getAllCharacters()
        }
    }

    override suspend fun saveAllCharacters(characters: List<CharacterEntity>) {
        withContext(Dispatchers.IO) {
            database.insertAllCharacters(characters)
        }
    }

    override suspend fun clearDatabase() {
        database.clearAllCharacterEntity()
    }
}
