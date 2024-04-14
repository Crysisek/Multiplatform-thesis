package pl.edu.pb.androidnativeapp.data.infinitelist.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.edu.pb.androidnativeapp.data.model.Page
import pl.edu.pb.androidnativeapp.data.network.CharacterApi

class InfiniteListDataSourceImpl(
    private val characterApi: CharacterApi,
) : InfiniteListDataSource {

    override suspend fun getCharactersPage(url: String): Page {
        return withContext(Dispatchers.IO) {
            val response = characterApi.getData(url)
            if (response.isSuccessful) {
                response.body()!!
            } else {
                throw RuntimeException(response.message(), null)
            }
        }
    }
}
