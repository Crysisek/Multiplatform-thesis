package pl.edu.pb.kotlinmultiplatformapp.data.di

import pl.edu.pb.kotlinmultiplatformapp.data.database.di.databaseDataModule
import pl.edu.pb.kotlinmultiplatformapp.data.infinitelist.di.infiniteListModule

val sharedDataModule = listOf(
    coreDataModule,
    infiniteListModule,
    databaseDataModule,
)
