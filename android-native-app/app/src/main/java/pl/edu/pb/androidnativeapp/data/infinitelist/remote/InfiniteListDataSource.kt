package pl.edu.pb.androidnativeapp.data.infinitelist.remote

import pl.edu.pb.androidnativeapp.data.model.Page

interface InfiniteListDataSource {

    suspend fun getCharactersPage(url: String): Page
}
