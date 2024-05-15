package pl.edu.pb.kotlinmultiplatformapp.data.database.repository

import pl.edu.pb.kotlinmultiplatformapp.data.database.local.DatabaseDataSource
import pl.edu.pb.kotlinmultiplatformapp.data.infinitelist.remote.InfiniteListDataSource
import pl.edu.pb.kotlinmultiplatformapp.data.model.CharacterEntity
import pl.edu.pb.kotlinmultiplatformapp.model.Character

class DatabaseRepositoryImpl(
    private val infiniteListDataSource: InfiniteListDataSource,
    private val databaseDataSource: DatabaseDataSource,
) : DatabaseRepository {
    override suspend fun getAllCharacters(): List<Character> {
        return databaseDataSource.getAllCharacters().map {
            Character(
                id = it.id.toString(),
                name = it.name,
                status = it.status,
                species = it.species,
                gender = it.gender,
                image = it.image,
            )
        }
    }

    override suspend fun saveAllCharacters() {
        var url: String? = "https://rickandmortyapi.com/api/character"
        val allCharacters = mutableListOf<CharacterEntity>()
        do {
            val charactersPage = infiniteListDataSource.getCharactersPage(url!!)
            allCharacters += charactersPage.results
            url = charactersPage.info.next
        } while (url != null)
        databaseDataSource.saveAllCharacters(allCharacters)
    }

    override suspend fun clearDatabase() {
        databaseDataSource.clearDatabase()
    }
}
