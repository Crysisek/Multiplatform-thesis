import 'package:flutter_multiplatform_app/model/character.dart';
import 'package:flutter_multiplatform_app/model/characters.dart';

abstract interface class InfiniteListRepository {
  Future<Characters> getCharacters(String url);

  Future<List<Character>> getAllCharacters();
}
