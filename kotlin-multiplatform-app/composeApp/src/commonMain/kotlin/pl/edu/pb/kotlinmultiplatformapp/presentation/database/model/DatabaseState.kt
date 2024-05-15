package pl.edu.pb.kotlinmultiplatformapp.presentation.database.model

import pl.edu.pb.kotlinmultiplatformapp.model.Character
import pl.edu.pb.kotlinmultiplatformapp.presentation.state.State

sealed class DatabaseState : State {

    data object None : DatabaseState()

    data class SavingContent(
        val isLoading: Boolean,
        val saveCharacters: () -> Unit,
    ) : DatabaseState()

    data class RetrievingContent(
        val characters: List<Character>,
        val isLoading: Boolean,
        val getCharacters: () -> Unit,
    ) : DatabaseState()
}
