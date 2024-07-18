import 'package:flutter_multiplatform_app/model/character.dart';

abstract interface class DatabaseRepository {
  Future<List<Character>> getAllCharacters();

  Future<void> saveAllCharacters();

  Future<void> clearDatabase();
}
