package pl.edu.pb.androidnativeapp.data.network

import pl.edu.pb.androidnativeapp.data.model.Page
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CharacterApi {

    @GET
    suspend fun getData(@Url url: String): Response<Page>
}
