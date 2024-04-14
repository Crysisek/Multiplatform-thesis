package pl.edu.pb.androidnativeapp.data.infinitelist.repository

import pl.edu.pb.androidnativeapp.data.infinitelist.remote.InfiniteListDataSource
import pl.edu.pb.androidnativeapp.model.Character
import pl.edu.pb.androidnativeapp.model.Characters

class InfiniteListRepositoryImpl(
    private val infiniteListDataSource: InfiniteListDataSource,
) : InfiniteListRepository {
    override suspend fun getCharacters(url: String): Characters {
        val charactersPage = infiniteListDataSource.getCharactersPage(url)
        return Characters(
            characters = charactersPage.results.map {
                Character(
                    id = it.id,
                    name = it.name,
                    status = it.status,
                    species = it.species,
                    gender = it.gender,
                    image = it.image,
                )
            },
            nextPageUrl = charactersPage.info.next,
        )
    }

    override suspend fun getAllCharacters(): List<Character> {
        var url: String? = "https://rickandmortyapi.com/api/character"
        val allCharacters = mutableListOf<Character>()
        do {
            val charactersPage = infiniteListDataSource.getCharactersPage(url!!)
            allCharacters += charactersPage.results.map {
                Character(
                    id = it.id,
                    name = it.name,
                    status = it.status,
                    species = it.species,
                    gender = it.gender,
                    image = it.image,
                )
            }
            url = charactersPage.info.next
        } while (url != null)
        return allCharacters
    }
}
