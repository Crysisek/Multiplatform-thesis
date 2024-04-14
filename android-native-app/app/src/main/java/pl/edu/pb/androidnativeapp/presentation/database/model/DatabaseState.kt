package pl.edu.pb.androidnativeapp.presentation.database.model

import pl.edu.pb.androidnativeapp.model.Character
import pl.edu.pb.androidnativeapp.presentation.state.State

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
