package pl.edu.pb.androidnativeapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.edu.pb.androidnativeapp.data.di.dataModule
import pl.edu.pb.androidnativeapp.presentation.di.presentationModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(dataModule + presentationModule)
        }
    }
}
