import 'package:flutter_multiplatform_app/data/model/page.dart';

abstract interface class InfiniteListDataSource {
  Future<Page> getCharactersPage(String url);
}
