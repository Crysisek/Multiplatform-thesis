package pl.edu.pb.androidnativeapp.data.infinitelist.di

import org.koin.dsl.module
import pl.edu.pb.androidnativeapp.data.infinitelist.remote.InfiniteListDataSource
import pl.edu.pb.androidnativeapp.data.infinitelist.remote.InfiniteListDataSourceImpl
import pl.edu.pb.androidnativeapp.data.infinitelist.repository.InfiniteListRepository
import pl.edu.pb.androidnativeapp.data.infinitelist.repository.InfiniteListRepositoryImpl

val infiniteListModule = module {
    single<InfiniteListDataSource> { InfiniteListDataSourceImpl(get()) }
    factory<InfiniteListRepository> { InfiniteListRepositoryImpl(get()) }
}
