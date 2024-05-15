package pl.edu.pb.kotlinmultiplatformapp.ui.di

import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.ui.AndroidHardwareUIFactory
import pl.edu.pb.kotlinmultiplatformapp.ui.HardwareUIFactory

val androidUIModule = listOf(
    module {
        single<HardwareUIFactory> {
            AndroidHardwareUIFactory()
        }
    }
)
