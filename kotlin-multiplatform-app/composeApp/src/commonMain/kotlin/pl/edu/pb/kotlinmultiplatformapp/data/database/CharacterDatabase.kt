package pl.edu.pb.kotlinmultiplatformapp.data.database

import pl.edu.pb.kotlinmultiplatformapp.data.model.CharacterEntity

internal class CharacterDatabase(databaseDriverFactory: DatabaseDriverFactory) {

    private val database = InnerCharacterDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.innerCharacterDatabaseQueries

    internal fun getAllCharacters(): List<CharacterEntity> {
        return dbQuery.selectAllCharacterEntity(::mapCharacterSelecting).executeAsList()
    }

    internal fun insertAllCharacters(characters: List<CharacterEntity>) {
        dbQuery.transaction {
            characters.forEach { character ->
                dbQuery.insertCharacterEntity(
                    id = character.id.toString(),
                    name = character.name,
                    status = character.status,
                    species = character.species,
                    gender = character.gender,
                    image = character.image,
                )
            }
        }
    }

    internal fun clearAllCharacterEntity() {
        dbQuery.removeAllCharacterEntity()
    }

    private fun mapCharacterSelecting(
        id: String,
        name: String,
        status: String,
        species: String,
        gender: String,
        image: String,
    ): CharacterEntity {
        return CharacterEntity(
            id = id.toInt(),
            name = name,
            status = status,
            species = species,
            gender = gender,
            image = image,
        )
    }
}
