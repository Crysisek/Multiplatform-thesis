package pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.model

import pl.edu.pb.kotlinmultiplatformapp.model.Character
import pl.edu.pb.kotlinmultiplatformapp.presentation.state.State

sealed class InfiniteListState : State {

    data object None : InfiniteListState()

    data class Content(
        val characters: List<Character>,
        val loadMoreCharacters: () -> Unit,
    ) : InfiniteListState()
}
