package pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import pl.edu.pb.kotlinmultiplatformapp.data.infinitelist.repository.InfiniteListRepository
import pl.edu.pb.kotlinmultiplatformapp.presentation.DataSourceType
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.model.InfiniteListState
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state.InfiniteListReducer
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state.model.InfiniteListAction

class InfiniteListViewModel(
    dataSourceType: DataSourceType,
    private val reducer: InfiniteListReducer,
    private val infiniteListRepository: InfiniteListRepository,
) : ViewModel() {

    val state: Flow<InfiniteListState> = reducer.state

    private var nextPageUrl: String? = null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val action = if (dataSourceType == DataSourceType.LOCAL) {
                InfiniteListAction.SetContent(
                    characters = infiniteListRepository.getAllCharacters(),
                    loadMoreCharacters = {},
                )
            } else {
                InfiniteListAction.SetContent(
                    characters = infiniteListRepository.getCharacters(FIRST_PAGE_URL)
                        .also { nextPageUrl = it.nextPageUrl }
                        .characters,
                    loadMoreCharacters = ::loadMoreCharacters,
                )

            }
            reducer.update(action)
        }
    }

    private fun loadMoreCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            nextPageUrl?.let { url ->
                reducer.update(
                    InfiniteListAction.UpdateContent(
                        infiniteListRepository.getCharacters(url)
                            .also { nextPageUrl = it.nextPageUrl }
                            .characters,
                    )
                )
            }
        }
    }

    private companion object {
        const val FIRST_PAGE_URL = "https://rickandmortyapi.com/api/character"
    }
}
