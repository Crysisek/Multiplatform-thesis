import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';

class CharacterDatabase {
  static Database? _db;

  static Future<Database> getDatabase() async {
    _db ??= await openDatabase(
      join(await getDatabasesPath(), 'character.db'),
      onCreate: (db, version) {
        return db.execute(
          '''
          CREATE TABLE CharacterEntity(
            id TEXT NOT NULL PRIMARY KEY,
            name TEXT NOT NULL,
            status TEXT NOT NULL,
            species TEXT NOT NULL,
            gender TEXT NOT NULL,
            image TEXT NOT NULL
          )
        ''',
        );
      },
      version: 1,
    );
    return _db!;
  }

  static closeDatabase() async {
    await _db?.close();
  }
}
