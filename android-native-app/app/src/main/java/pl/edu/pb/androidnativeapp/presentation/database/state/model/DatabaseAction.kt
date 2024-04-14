package pl.edu.pb.androidnativeapp.presentation.database.state.model

import pl.edu.pb.androidnativeapp.model.Character
import pl.edu.pb.androidnativeapp.presentation.state.Action

sealed class DatabaseAction : Action {

    data object SetLoading: DatabaseAction()

    data class SetFinishedSaving(
        val getCharacters: () -> Unit,
    ): DatabaseAction()

    data class SetFunctionalities(
        val saveCharacters: () -> Unit,
    ) : DatabaseAction()

    data class UpdateContent(
        val characters: List<Character>,
    ) : DatabaseAction()
}
