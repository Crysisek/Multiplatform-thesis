import 'package:bloc/bloc.dart';
import 'package:flutter_multiplatform_app/data/infinitylist/repository/infinite_list_repository.dart';
import 'package:flutter_multiplatform_app/presentation/infinitylist/bloc/infinite_list_event.dart';
import 'package:flutter_multiplatform_app/presentation/infinitylist/bloc/infinite_list_state.dart';

class InfiniteListBloc extends Bloc<InfiniteListEvent, InfiniteListState> {
  InfiniteListBloc({required InfiniteListRepository infiniteListRepository})
      : _infiniteListRepository = infiniteListRepository,
        super(const InfiniteListState()) {
    on<CharactersFetched>(_onCharactersFetched);
    on<AllCharactersFetched>(_onAllCharactersFetched);
  }

  final InfiniteListRepository _infiniteListRepository;

  static const String firstPageUrl = "https://rickandmortyapi.com/api/character";
  String? nextUrl;

  Future<void> _onCharactersFetched(CharactersFetched event, Emitter<InfiniteListState> emit) async {
    try {
      if (state.status == InfiniteListStatus.initial) {
        final characters = await _infiniteListRepository.getCharacters(firstPageUrl);
        nextUrl = characters.nextPageUrl;
        return emit(state.copyWith(
          status: InfiniteListStatus.success,
          characters: characters.characters,
        ));
      }
      final characters = await _infiniteListRepository.getCharacters(nextUrl!);
      emit(state.copyWith(
        status: InfiniteListStatus.success,
        characters: List.of(state.characters)..addAll(characters.characters),
      ));
    } catch (_) {
      emit(state.copyWith(status: InfiniteListStatus.failure));
    }
  }

  Future<void> _onAllCharactersFetched(AllCharactersFetched event, Emitter<InfiniteListState> emit) async {
    try {
      final characters = await _infiniteListRepository.getAllCharacters();
      emit(state.copyWith(
        status: InfiniteListStatus.success,
        characters: List.of(state.characters)..addAll(characters),
      ));
    } catch (_) {
      emit(state.copyWith(status: InfiniteListStatus.failure));
    }
  }
}
