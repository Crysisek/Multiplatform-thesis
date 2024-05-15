package pl.edu.pb.kotlinmultiplatformapp.data.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.data.database.AndroidDatabaseDriverFactory
import pl.edu.pb.kotlinmultiplatformapp.data.database.DatabaseDriverFactory

val androidDataModule = listOf(
    module {
        single<DatabaseDriverFactory> {
            AndroidDatabaseDriverFactory(androidContext())
        }
    }
)
