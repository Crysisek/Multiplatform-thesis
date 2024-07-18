import 'package:flutter_multiplatform_app/data/database/local/database_data_source.dart';
import 'package:flutter_multiplatform_app/data/database/repository/database_repository.dart';
import 'package:flutter_multiplatform_app/data/infinitylist/remote/infinite_list_data_source.dart';
import 'package:flutter_multiplatform_app/data/model/character_entity.dart';
import 'package:flutter_multiplatform_app/model/character.dart';

class DatabaseRepositoryImpl implements DatabaseRepository {
  DatabaseRepositoryImpl({required DatabaseDataSource databaseDataSource, required InfiniteListDataSource infiniteListDataSource})
      : _databaseDataSource = databaseDataSource,
        _infiniteListDataSource = infiniteListDataSource;

  final DatabaseDataSource _databaseDataSource;
  final InfiniteListDataSource _infiniteListDataSource;

  @override
  Future<List<Character>> getAllCharacters() async {
    final characterEntities = await _databaseDataSource.getAllCharacters();

    return characterEntities
        .map((entity) => Character(
            id: entity.id,
            name: entity.name,
            status: entity.status,
            species: entity.species,
            gender: entity.gender,
            image: entity.image))
        .toList();
  }

  @override
  Future<void> saveAllCharacters() async {
    String? url = "https://rickandmortyapi.com/api/character";
    late List<CharacterEntity> allCharacters = [];
    do {
      final charactersPage = await _infiniteListDataSource.getCharactersPage(url!);
      allCharacters += charactersPage.results;
      url = charactersPage.info.next;
    } while (url != null);
    _databaseDataSource.saveAllCharacters(allCharacters);
  }

  @override
  Future<void> clearDatabase() async {
    _databaseDataSource.clearDatabase();
  }
}
