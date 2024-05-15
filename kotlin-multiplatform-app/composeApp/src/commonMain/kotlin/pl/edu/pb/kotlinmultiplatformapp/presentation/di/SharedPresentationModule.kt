package pl.edu.pb.kotlinmultiplatformapp.presentation.di

import pl.edu.pb.kotlinmultiplatformapp.presentation.database.di.databasePresentationModule
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.di.infiniteListPresentationModule

val sharedPresentationModule = listOf(
    infiniteListPresentationModule,
    databasePresentationModule,
)
