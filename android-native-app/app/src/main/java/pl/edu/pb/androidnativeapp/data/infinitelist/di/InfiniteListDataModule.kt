package pl.edu.pb.androidnativeapp.data.infinitelist.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import pl.edu.pb.androidnativeapp.data.infinitelist.network.InfiniteListApi
import pl.edu.pb.androidnativeapp.data.infinitelist.remote.InfiniteListDataSource
import pl.edu.pb.androidnativeapp.data.infinitelist.remote.InfiniteListDataSourceImpl
import pl.edu.pb.androidnativeapp.data.infinitelist.repository.InfiniteListRepository
import pl.edu.pb.androidnativeapp.data.infinitelist.repository.InfiniteListRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://rickandmortyapi.com/api/"
private const val DEFAULT_TIMEOUT = 15L

val infiniteListModule = module {
    factory {
        OkHttpClient().newBuilder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
    factory {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    factory<InfiniteListApi> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
            .create()
    }
    single<InfiniteListDataSource> { InfiniteListDataSourceImpl(get()) }
    factory<InfiniteListRepository> { InfiniteListRepositoryImpl(get()) }
}
