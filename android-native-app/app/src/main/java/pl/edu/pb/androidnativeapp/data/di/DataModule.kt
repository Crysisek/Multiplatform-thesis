package pl.edu.pb.androidnativeapp.data.di

import pl.edu.pb.androidnativeapp.data.database.di.databaseDataModule
import pl.edu.pb.androidnativeapp.data.infinitelist.di.infiniteListModule

val dataModule = listOf(
    coreDataModule,
    infiniteListModule,
    databaseDataModule,
)
