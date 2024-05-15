package pl.edu.pb.kotlinmultiplatformapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.edu.pb.kotlinmultiplatformapp.data.di.androidDataModule
import pl.edu.pb.kotlinmultiplatformapp.data.di.sharedDataModule
import pl.edu.pb.kotlinmultiplatformapp.presentation.di.sharedPresentationModule
import pl.edu.pb.kotlinmultiplatformapp.ui.di.androidUIModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(androidUIModule + androidDataModule + sharedDataModule + sharedPresentationModule)
        }
    }
}
