import 'package:flutter_multiplatform_app/data/model/character_entity.dart';
import 'package:flutter_multiplatform_app/data/model/info.dart';

final class Page {
  const Page({
    required this.info,
    required this.results,
  });

  final Info info;
  final List<CharacterEntity> results;
}
