import 'package:equatable/equatable.dart';
import 'package:flutter_multiplatform_app/model/character.dart';

enum DatabaseStatus { initial, loading, saved, loaded, failure }

final class DatabaseState extends Equatable {
  const DatabaseState({
    this.status = DatabaseStatus.initial,
    this.characters = const <Character>[],
  });

  final DatabaseStatus status;
  final List<Character> characters;

  DatabaseState copyWith({
    DatabaseStatus? status,
    List<Character>? characters,
  }) {
    return DatabaseState(
      status: status ?? this.status,
      characters: characters ?? this.characters,
    );
  }

  @override
  String toString() {
    return '''DatabaseState { status: $status, characters: ${characters.length} }''';
  }

  @override
  List<Object> get props => [status, characters];
}
