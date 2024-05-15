package pl.edu.pb.kotlinmultiplatformapp.ui.di

import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.UIViewControllerFactory
import pl.edu.pb.kotlinmultiplatformapp.ui.HardwareUIFactory
import pl.edu.pb.kotlinmultiplatformapp.ui.IOSHardwareUIFactory

fun iosUIModule(uiViewControllerFactory: UIViewControllerFactory) = listOf(
    module {
        single<HardwareUIFactory> {
            IOSHardwareUIFactory(uiViewControllerFactory)
        }
    }
)
