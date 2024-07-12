import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_multiplatform_app/di/get_it.dart';
import 'package:flutter_multiplatform_app/presentation/database/bloc/database_bloc.dart';
import 'package:flutter_multiplatform_app/presentation/database/bloc/database_event.dart';
import 'package:flutter_multiplatform_app/presentation/database/bloc/database_state.dart';
import 'package:flutter_multiplatform_app/ui/widget/infinitelist/character_list_item.dart';

class DatabaseScreen extends StatelessWidget {
  const DatabaseScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: BlocProvider.value(
        value: getIt<DatabaseBloc>(),
        child: const Database(),
      ),
    );
  }
}

class Database extends StatelessWidget {
  const Database({super.key});

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<DatabaseBloc, DatabaseState>(
      builder: (context, state) {
        switch (state.status) {
          case DatabaseStatus.failure:
            return const Center(child: Text('failed to save/load characters'));
          case DatabaseStatus.loaded:
            if (state.characters.isEmpty) {
              return const Center(child: Text('no characters'));
            }
            return ListView.builder(
              itemBuilder: (BuildContext context, int index) {
                return CharacterListItem(character: state.characters[index]);
              },
              itemCount: state.characters.length,
            );
          case DatabaseStatus.saved:
            return Center(
              child: ElevatedButton(
                onPressed: () => context.read<DatabaseBloc>().add(CharactersLoaded()),
                child: const Text('Load'),
              ),
            );
          case DatabaseStatus.loading:
            return const Center(child: CircularProgressIndicator());
          case DatabaseStatus.initial:
            return Center(
              child: ElevatedButton(
                onPressed: () => context.read<DatabaseBloc>().add(CharactersSaved()),
                child: const Text('Save'),
              ),
            );
        }
      },
    );
  }
}
