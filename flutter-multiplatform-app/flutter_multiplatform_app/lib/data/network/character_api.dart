import 'dart:convert';

import 'package:flutter_multiplatform_app/data/model/character_entity.dart';
import 'package:flutter_multiplatform_app/data/model/info.dart';
import 'package:flutter_multiplatform_app/data/model/page.dart';
import 'package:http/http.dart' as http;

class CharacterApi {
  final http.Client httpClient = http.Client();

  Future<Page> getData(String url) async {
    final response = await httpClient.get(Uri.parse(url));
    if (response.statusCode == 200) {
      final body = json.decode(response.body) as Map<String, dynamic>;
      final page = Page(
        info: Info.fromJson(body['info']),
        results: (body['results'] as List).map((dynamic json) {
          final character = json as Map<String, dynamic>;
          return CharacterEntity.fromJson(character);
        }).toList(),
      );
      return page;
    }
    throw Exception('Error fetching at $url');
  }
}
