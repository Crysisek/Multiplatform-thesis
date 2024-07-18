import 'package:equatable/equatable.dart';
import 'package:flutter_multiplatform_app/model/character.dart';

enum InfiniteListStatus { initial, success, failure }

final class InfiniteListState extends Equatable {
  const InfiniteListState({
    this.status = InfiniteListStatus.initial,
    this.characters = const <Character>[],
  });

  final InfiniteListStatus status;
  final List<Character> characters;

  InfiniteListState copyWith({
    InfiniteListStatus? status,
    List<Character>? characters,
  }) {
    return InfiniteListState(
      status: status ?? this.status,
      characters: characters ?? this.characters,
    );
  }

  @override
  String toString() {
    return '''InfiniteListState { status: $status, characters: ${characters.length} }''';
  }

  @override
  List<Object> get props => [status, characters];
}
