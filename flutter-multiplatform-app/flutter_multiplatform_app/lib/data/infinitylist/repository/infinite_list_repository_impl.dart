import 'package:flutter_multiplatform_app/data/infinitylist/remote/infinite_list_data_source.dart';
import 'package:flutter_multiplatform_app/data/infinitylist/repository/infinite_list_repository.dart';
import 'package:flutter_multiplatform_app/model/character.dart';
import 'package:flutter_multiplatform_app/model/characters.dart';

class InfiniteListRepositoryImpl implements InfiniteListRepository {
  InfiniteListRepositoryImpl({required InfiniteListDataSource infiniteListDataSource})
      : _infiniteListDataSource = infiniteListDataSource;

  final InfiniteListDataSource _infiniteListDataSource;

  @override
  Future<Characters> getCharacters(String url) async {
    final charactersPage = await _infiniteListDataSource.getCharactersPage(url);
    return Characters(
        nextPageUrl: charactersPage.info.next,
        characters: charactersPage.results.map((result) {
          return Character(
              id: result.id,
              name: result.name,
              status: result.status,
              species: result.species,
              gender: result.gender,
              image: result.image);
        }).toList());
  }

  @override
  Future<List<Character>> getAllCharacters() async {
    String? url = "https://rickandmortyapi.com/api/character";
    late List<Character> allCharacters = [];
    do {
      final charactersPage = await _infiniteListDataSource.getCharactersPage(url!);
      allCharacters += charactersPage.results.map((result) {
        return Character(
            id: result.id,
            name: result.name,
            status: result.status,
            species: result.species,
            gender: result.gender,
            image: result.image);
      }).toList();
      url = charactersPage.info.next;
    } while (url != null);
    return allCharacters;
  }
}
