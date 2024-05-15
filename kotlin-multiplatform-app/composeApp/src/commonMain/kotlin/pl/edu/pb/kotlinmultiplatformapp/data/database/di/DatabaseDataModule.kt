package pl.edu.pb.kotlinmultiplatformapp.data.database.di

import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.data.database.local.DatabaseDataSource
import pl.edu.pb.kotlinmultiplatformapp.data.database.local.DatabaseDataSourceImpl
import pl.edu.pb.kotlinmultiplatformapp.data.database.repository.DatabaseRepository
import pl.edu.pb.kotlinmultiplatformapp.data.database.repository.DatabaseRepositoryImpl

val databaseDataModule = module {
    single<DatabaseDataSource> { DatabaseDataSourceImpl(get()) }
    factory<DatabaseRepository> { DatabaseRepositoryImpl(get(), get()) }
}
