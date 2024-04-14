package pl.edu.pb.androidnativeapp.data.database.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.edu.pb.androidnativeapp.data.database.CharacterDatabase
import pl.edu.pb.androidnativeapp.data.model.CharacterEntity
import pl.edu.pb.androidnativeapp.data.model.Page
import pl.edu.pb.androidnativeapp.data.network.CharacterApi

class DatabaseDataSourceImpl(
    private val characterDatabase: CharacterDatabase,
) : DatabaseDataSource {

    private val characterDao = characterDatabase.characterDao()

    override suspend fun getAllCharacters(): List<CharacterEntity> {
        return withContext(Dispatchers.IO) {
            characterDao.getAll()
        }
    }

    override suspend fun saveAllCharacters(characters: List<CharacterEntity>) {
        withContext(Dispatchers.IO) {
            characterDao.insertAll(characters)
        }
    }

    override suspend fun clearDatabase() {
        characterDatabase.clearAllTables()
    }
}
