import 'package:equatable/equatable.dart';

sealed class DatabaseEvent extends Equatable {
  @override
  List<Object> get props => [];
}

final class CharactersSaved extends DatabaseEvent {}

final class CharactersLoaded extends DatabaseEvent {}
