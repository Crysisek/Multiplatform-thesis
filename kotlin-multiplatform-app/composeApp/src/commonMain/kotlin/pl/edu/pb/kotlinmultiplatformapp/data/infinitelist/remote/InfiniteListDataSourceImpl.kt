package pl.edu.pb.kotlinmultiplatformapp.data.infinitelist.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import pl.edu.pb.kotlinmultiplatformapp.data.model.Page
import pl.edu.pb.kotlinmultiplatformapp.data.network.CharacterApi

class InfiniteListDataSourceImpl(
    private val characterApi: CharacterApi,
) : InfiniteListDataSource {

    override suspend fun getCharactersPage(url: String): Page {
        return withContext(Dispatchers.IO) {
            characterApi.getData(url)
        }
    }
}
