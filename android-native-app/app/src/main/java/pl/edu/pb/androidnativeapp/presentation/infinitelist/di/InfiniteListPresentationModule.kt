package pl.edu.pb.androidnativeapp.presentation.infinitelist.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.edu.pb.androidnativeapp.presentation.infinitelist.state.InfiniteListReducer
import pl.edu.pb.androidnativeapp.presentation.infinitelist.viewmodel.InfiniteListViewModel

val infiniteListPresentationModule = module {
    factory { InfiniteListReducer() }
    viewModel<InfiniteListViewModel> {
        InfiniteListViewModel(get(), get())
    }
}
