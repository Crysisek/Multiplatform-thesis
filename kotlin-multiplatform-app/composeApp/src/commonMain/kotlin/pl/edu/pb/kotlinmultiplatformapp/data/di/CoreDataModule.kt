package pl.edu.pb.kotlinmultiplatformapp.data.di

import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.data.network.CharacterApi

val coreDataModule = module {
    factory<CharacterApi> {
        CharacterApi()
    }
}
