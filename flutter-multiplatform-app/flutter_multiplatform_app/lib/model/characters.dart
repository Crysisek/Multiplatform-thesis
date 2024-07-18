import 'package:flutter_multiplatform_app/model/character.dart';

final class Characters {
  const Characters({required this.characters, this.nextPageUrl});

  final List<Character> characters;
  final String? nextPageUrl;
}