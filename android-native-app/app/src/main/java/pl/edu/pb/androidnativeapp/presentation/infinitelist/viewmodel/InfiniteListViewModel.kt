package pl.edu.pb.androidnativeapp.presentation.infinitelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import pl.edu.pb.androidnativeapp.data.infinitelist.repository.InfiniteListRepository
import pl.edu.pb.androidnativeapp.presentation.infinitelist.model.InfiniteListState
import pl.edu.pb.androidnativeapp.presentation.infinitelist.state.InfiniteListReducer
import pl.edu.pb.androidnativeapp.presentation.infinitelist.state.model.InfiniteListAction

class InfiniteListViewModel(
    private val reducer: InfiniteListReducer,
    private val infiniteListRepository: InfiniteListRepository,
) : ViewModel() {

    val state: Flow<InfiniteListState> = reducer.state

    private var nextPageUrl: String? = null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            reducer.update(
                InfiniteListAction.SetContent(
                    characters = infiniteListRepository.getCharacters(FIRST_PAGE_URL)
                        .also { nextPageUrl = it.nextPageUrl }
                        .characters,
                    loadMoreCharacters = ::loadMoreCharacters,
                )
            )
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
