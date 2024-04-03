package pl.edu.pb.androidnativeapp.presentation.infinitelist.model

import pl.edu.pb.androidnativeapp.model.Character
import pl.edu.pb.androidnativeapp.presentation.state.State

sealed class InfiniteListState : State {

    data object None : InfiniteListState()

    data class Content(
        val characters: List<Character>,
        val loadMoreCharacters: () -> Unit,
    ) : InfiniteListState()
}
