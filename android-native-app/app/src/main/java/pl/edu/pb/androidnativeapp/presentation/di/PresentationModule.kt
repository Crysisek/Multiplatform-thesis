package pl.edu.pb.androidnativeapp.presentation.di

import pl.edu.pb.androidnativeapp.presentation.database.di.databasePresentationModule
import pl.edu.pb.androidnativeapp.presentation.infinitelist.di.infiniteListPresentationModule


val presentationModule = listOf(
    infiniteListPresentationModule,
    databasePresentationModule,
)
