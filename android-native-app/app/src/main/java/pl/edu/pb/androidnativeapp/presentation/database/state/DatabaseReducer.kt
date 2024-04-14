package pl.edu.pb.androidnativeapp.presentation.database.state

import pl.edu.pb.androidnativeapp.presentation.database.model.DatabaseState
import pl.edu.pb.androidnativeapp.presentation.database.state.model.DatabaseAction
import pl.edu.pb.androidnativeapp.presentation.database.state.model.DatabaseAction.SetFunctionalities
import pl.edu.pb.androidnativeapp.presentation.state.StateReducer

class DatabaseReducer : StateReducer<DatabaseState, DatabaseAction>(DatabaseState.None) {

    override fun reduce(action: DatabaseAction, currentState: DatabaseState): DatabaseState {
        return when (action) {
            is SetFunctionalities -> onSetFunctionalities(action)
            is DatabaseAction.UpdateContent -> onUpdateContent(action, currentState)
            is DatabaseAction.SetFinishedSaving -> onSetFinishedSaving(action, currentState)
            DatabaseAction.SetLoading -> onSetLoading(currentState)
        }
    }

    private fun onSetFunctionalities(action: SetFunctionalities): DatabaseState {
        return DatabaseState.SavingContent(
            isLoading = false,
            saveCharacters = action.saveCharacters,
        )
    }

    private fun onUpdateContent(action: DatabaseAction.UpdateContent, currentState: DatabaseState): DatabaseState {
        return if (currentState is DatabaseState.RetrievingContent) {
            currentState.copy(characters = action.characters, isLoading = false)
        } else {
            currentState
        }
    }

    private fun onSetFinishedSaving(action: DatabaseAction.SetFinishedSaving, currentState: DatabaseState): DatabaseState {
        return if (currentState is DatabaseState.SavingContent) {
            DatabaseState.RetrievingContent(
                characters = emptyList(),
                isLoading = false,
                getCharacters = action.getCharacters,
            )
        } else {
            currentState
        }
    }

    private fun onSetLoading(currentState: DatabaseState): DatabaseState {
        return when (currentState) {
            is DatabaseState.SavingContent -> {
                currentState.copy(isLoading = true)
            }

            is DatabaseState.RetrievingContent -> {
                currentState.copy(isLoading = true)
            }

            else -> {
                currentState
            }
        }
    }
}
