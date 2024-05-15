package pl.edu.pb.kotlinmultiplatformapp.presentation.database.state.model

import pl.edu.pb.kotlinmultiplatformapp.model.Character
import pl.edu.pb.kotlinmultiplatformapp.presentation.state.Action

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
