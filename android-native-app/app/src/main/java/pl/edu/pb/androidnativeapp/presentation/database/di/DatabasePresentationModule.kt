package pl.edu.pb.androidnativeapp.presentation.database.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.edu.pb.androidnativeapp.presentation.database.state.DatabaseReducer
import pl.edu.pb.androidnativeapp.presentation.database.viewmodel.DatabaseViewModel

val databasePresentationModule = module {
    factory { DatabaseReducer() }
    viewModel<DatabaseViewModel> {
        DatabaseViewModel(
            reducer = get(),
            databaseRepository = get()
        )
    }
}
