package pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state.model

import pl.edu.pb.kotlinmultiplatformapp.model.Character
import pl.edu.pb.kotlinmultiplatformapp.presentation.state.Action

sealed class InfiniteListAction : Action {
    data class SetContent(
        val characters: List<Character>,
        val loadMoreCharacters: () -> Unit,
    ) : InfiniteListAction()

    data class UpdateContent(
        val characters: List<Character>,
    ) : InfiniteListAction()
}
