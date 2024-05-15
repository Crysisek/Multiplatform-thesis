package pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.di

import org.koin.dsl.module
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state.InfiniteListReducer
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.viewmodel.InfiniteListViewModel

val infiniteListPresentationModule = module {
    factory { InfiniteListReducer() }
    factory<InfiniteListViewModel> { params ->
        InfiniteListViewModel(
            dataSourceType = params.get(),
            reducer = get(),
            infiniteListRepository = get()
        )
    }
}
