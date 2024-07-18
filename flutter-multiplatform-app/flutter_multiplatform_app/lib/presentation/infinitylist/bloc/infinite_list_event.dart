import 'package:equatable/equatable.dart';

sealed class InfiniteListEvent extends Equatable {
  @override
  List<Object> get props => [];
}

final class CharactersFetched extends InfiniteListEvent {}

final class AllCharactersFetched extends InfiniteListEvent {}
