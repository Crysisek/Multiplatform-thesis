package pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state

import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.model.InfiniteListState
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state.model.InfiniteListAction
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state.model.InfiniteListAction.SetContent
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.state.model.InfiniteListAction.UpdateContent
import pl.edu.pb.kotlinmultiplatformapp.presentation.state.StateReducer

class InfiniteListReducer : StateReducer<InfiniteListState, InfiniteListAction>(InfiniteListState.None) {

    override fun reduce(action: InfiniteListAction, currentState: InfiniteListState): InfiniteListState {
        return when (action) {
            is SetContent -> onSetContent(action)
            is UpdateContent -> onUpdateContent(action, currentState)
        }
    }

    private fun onSetContent(action: SetContent): InfiniteListState {
        return InfiniteListState.Content(characters = action.characters, loadMoreCharacters = action.loadMoreCharacters)
    }

    private fun onUpdateContent(action: UpdateContent, currentState: InfiniteListState): InfiniteListState {
        return if (currentState is InfiniteListState.Content) {
            currentState.copy(characters = currentState.characters + action.characters)
        } else {
            currentState
        }
    }
}
