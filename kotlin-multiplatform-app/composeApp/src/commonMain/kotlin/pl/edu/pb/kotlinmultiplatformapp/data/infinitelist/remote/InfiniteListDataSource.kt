package pl.edu.pb.kotlinmultiplatformapp.data.infinitelist.remote

import pl.edu.pb.kotlinmultiplatformapp.data.model.Page

interface InfiniteListDataSource {

    suspend fun getCharactersPage(url: String): Page
}
