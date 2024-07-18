import 'package:flutter_multiplatform_app/data/database/character_database.dart';
import 'package:flutter_multiplatform_app/data/database/local/database_data_source.dart';
import 'package:flutter_multiplatform_app/data/model/character_entity.dart';
import 'package:sqflite/sqflite.dart';

class DatabaseDataSourceImpl implements DatabaseDataSource {
  @override
  Future<List<CharacterEntity>> getAllCharacters() async {
    final db = await CharacterDatabase.getDatabase();
    final List<Map<String, Object?>> characters = await db.query('CharacterEntity');

    return [
      for (final {
      'id': id as String,
      'name': name as String,
      'status': status as String,
      'species': species as String,
      'gender': gender as String,
      'image': image as String,
      } in characters)
        CharacterEntity(id: int.parse(id), name: name, status: status, species: species, gender: gender, image: image),
    ];
  }

  @override
  Future<void> saveAllCharacters(List<CharacterEntity> characters) async {
    final db = await CharacterDatabase.getDatabase();
    Batch batch = db.batch();
    for (CharacterEntity character in characters) {
      batch.insert('CharacterEntity', character.toMap());
    }

    await batch.commit(noResult: true);
  }

  @override
  Future<void> clearDatabase() async {
    final db = await CharacterDatabase.getDatabase();

    await db.rawDelete("DELETE FROM CharacterEntity");
  }
}
