package pl.edu.pb.kotlinmultiplatformapp.di

import org.koin.core.context.startKoin
import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.UIViewControllerFactory
import pl.edu.pb.kotlinmultiplatformapp.data.database.di.iosDataModule
import pl.edu.pb.kotlinmultiplatformapp.data.di.sharedDataModule
import pl.edu.pb.kotlinmultiplatformapp.presentation.di.sharedPresentationModule
import pl.edu.pb.kotlinmultiplatformapp.ui.di.iosUIModule

fun initKoin(uiViewControllerFactory: UIViewControllerFactory) {
    startKoin {
        modules(iosUIModule(uiViewControllerFactory) + iosDataModule + sharedDataModule + sharedPresentationModule)
    }
}
