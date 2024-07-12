import 'package:flutter_multiplatform_app/data/infinitylist/remote/infinite_list_data_source.dart';
import 'package:flutter_multiplatform_app/data/model/page.dart';
import 'package:flutter_multiplatform_app/data/network/character_api.dart';


class InfiniteListDataSourceImpl implements InfiniteListDataSource {
  InfiniteListDataSourceImpl({required CharacterApi characterApi})
      : _characterApi = characterApi;

  final CharacterApi _characterApi;

  @override
  Future<Page> getCharactersPage(String url) {
    return _characterApi.getData(url);
  }
}
