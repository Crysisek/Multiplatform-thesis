import 'package:flutter_multiplatform_app/data/model/character_entity.dart';

abstract interface class DatabaseDataSource {
  Future<List<CharacterEntity>> getAllCharacters();

  Future<void> saveAllCharacters(List<CharacterEntity> characters);

  Future<void> clearDatabase();
}
