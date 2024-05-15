package pl.edu.pb.kotlinmultiplatformapp.data.database.di

import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.data.database.DatabaseDriverFactory
import pl.edu.pb.kotlinmultiplatformapp.data.database.IOSDatabaseDriverFactory

val iosDataModule = listOf(
    module {
        single<DatabaseDriverFactory> {
            IOSDatabaseDriverFactory()
        }
    }
)
