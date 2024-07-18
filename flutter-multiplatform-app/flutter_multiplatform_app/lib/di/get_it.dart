import 'package:flutter_multiplatform_app/data/database/local/database_data_source.dart';
import 'package:flutter_multiplatform_app/data/database/local/database_data_source_impl.dart';
import 'package:flutter_multiplatform_app/data/database/repository/database_repository.dart';
import 'package:flutter_multiplatform_app/data/database/repository/database_repository_impl.dart';
import 'package:flutter_multiplatform_app/data/infinitylist/remote/infinite_list_data_source.dart';
import 'package:flutter_multiplatform_app/data/infinitylist/remote/infinite_list_data_source_impl.dart';
import 'package:flutter_multiplatform_app/data/infinitylist/repository/infinite_list_repository.dart';
import 'package:flutter_multiplatform_app/data/infinitylist/repository/infinite_list_repository_impl.dart';
import 'package:flutter_multiplatform_app/data/network/character_api.dart';
import 'package:flutter_multiplatform_app/presentation/database/bloc/database_bloc.dart';
import 'package:flutter_multiplatform_app/presentation/infinitylist/bloc/infinite_list_bloc.dart';
import 'package:get_it/get_it.dart';

final getIt = GetIt.instance;

void setupGetIt() {
  /* data */
  getIt.registerFactory<CharacterApi>(() => CharacterApi());

  // datasources
  getIt.registerSingleton<InfiniteListDataSource>(InfiniteListDataSourceImpl(characterApi: getIt()));
  getIt.registerSingleton<DatabaseDataSource>(DatabaseDataSourceImpl());

  // repository
  getIt.registerFactory<InfiniteListRepository>(() => InfiniteListRepositoryImpl(infiniteListDataSource: getIt()));
  getIt.registerFactory<DatabaseRepository>(() => DatabaseRepositoryImpl(databaseDataSource: getIt(), infiniteListDataSource: getIt()));

  /* presentation */
  getIt.registerFactory<InfiniteListBloc>(() => InfiniteListBloc(infiniteListRepository: getIt()));
  getIt.registerFactory<DatabaseBloc>(() => DatabaseBloc(databaseRepository: getIt()));
}
