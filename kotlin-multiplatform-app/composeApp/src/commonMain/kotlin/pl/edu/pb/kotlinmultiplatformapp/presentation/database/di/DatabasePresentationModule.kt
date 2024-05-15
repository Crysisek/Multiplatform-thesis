package pl.edu.pb.kotlinmultiplatformapp.presentation.database.di

import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.presentation.database.state.DatabaseReducer
import pl.edu.pb.kotlinmultiplatformapp.presentation.database.viewmodel.DatabaseViewModel

val databasePresentationModule = module {
    factory { DatabaseReducer() }
    factory<DatabaseViewModel> {
        DatabaseViewModel(
            reducer = get(),
            databaseRepository = get()
        )
    }
}
