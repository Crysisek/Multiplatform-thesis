package pl.edu.pb.androidnativeapp.data.infinitelist.network

import pl.edu.pb.androidnativeapp.data.infinitelist.model.Page
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface InfiniteListApi {

    @GET
    suspend fun getData(@Url url: String): Response<Page>
}
