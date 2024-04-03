package pl.edu.pb.androidnativeapp.data.infinitelist.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.edu.pb.androidnativeapp.data.infinitelist.model.Page
import pl.edu.pb.androidnativeapp.data.infinitelist.network.InfiniteListApi

class InfiniteListDataSourceImpl(
    private val infiniteListApi: InfiniteListApi,
) : InfiniteListDataSource {

    override suspend fun getCharactersPage(url: String): Page {
        return withContext(Dispatchers.IO) {
            val response = infiniteListApi.getData(url)
            if (response.isSuccessful) {
                response.body()!!
            } else {
                throw RuntimeException(response.message(), null)
            }
        }
    }
}
