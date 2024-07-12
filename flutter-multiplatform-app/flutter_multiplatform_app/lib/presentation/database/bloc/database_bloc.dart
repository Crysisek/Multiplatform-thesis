import 'package:bloc/bloc.dart';
import 'package:flutter_multiplatform_app/data/database/repository/database_repository.dart';
import 'package:flutter_multiplatform_app/presentation/database/bloc/database_event.dart';
import 'package:flutter_multiplatform_app/presentation/database/bloc/database_state.dart';

class DatabaseBloc extends Bloc<DatabaseEvent, DatabaseState> {
  DatabaseBloc({required DatabaseRepository databaseRepository})
      : _databaseRepository = databaseRepository,
        super(const DatabaseState()) {
    _databaseRepository.clearDatabase();

    on<CharactersSaved>(_onCharactersSaved);
    on<CharactersLoaded>(_onCharactersLoaded);
  }

  final DatabaseRepository _databaseRepository;

  Future<void> _onCharactersSaved(CharactersSaved event, Emitter<DatabaseState> emit) async {
    try {
      if (state.status == DatabaseStatus.initial) {
        emit(state.copyWith(
          status: DatabaseStatus.loading,
        ));
        await _databaseRepository.saveAllCharacters();
        return emit(state.copyWith(
          status: DatabaseStatus.saved,
        ));
      }
    } catch (_) {
      emit(state.copyWith(status: DatabaseStatus.failure));
    }
  }

  Future<void> _onCharactersLoaded(CharactersLoaded event, Emitter<DatabaseState> emit) async {
    try {
      emit(state.copyWith(
        status: DatabaseStatus.loading,
      ));
      final characters = await _databaseRepository.getAllCharacters();
      emit(state.copyWith(
        status: DatabaseStatus.loaded,
        characters: characters,
      ));
    } catch (e) {
      print(e);
      emit(state.copyWith(status: DatabaseStatus.failure));
    }
  }
}
