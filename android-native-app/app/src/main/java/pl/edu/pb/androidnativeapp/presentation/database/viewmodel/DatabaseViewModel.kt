package pl.edu.pb.androidnativeapp.presentation.database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pl.edu.pb.androidnativeapp.data.database.repository.DatabaseRepository
import pl.edu.pb.androidnativeapp.presentation.database.model.DatabaseState
import pl.edu.pb.androidnativeapp.presentation.database.state.DatabaseReducer
import pl.edu.pb.androidnativeapp.presentation.database.state.model.DatabaseAction

class DatabaseViewModel(
    private val reducer: DatabaseReducer,
    private val databaseRepository: DatabaseRepository,
) : ViewModel() {

    val state: Flow<DatabaseState> = reducer.state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            databaseRepository.clearDatabase()
            reducer.update(
                DatabaseAction.SetFunctionalities(
                    ::saveCharacters,
                )
            )
        }
    }

    private fun saveCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                reducer.update(DatabaseAction.SetLoading)
            }
            databaseRepository.saveAllCharacters()
            withContext(Dispatchers.Main) {
                reducer.update(DatabaseAction.SetFinishedSaving(::getCharacters))
            }
        }
    }

    private fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                reducer.update(DatabaseAction.SetLoading)
            }
            val characters = databaseRepository.getAllCharacters()
            withContext(Dispatchers.Main) {
                reducer.update(DatabaseAction.UpdateContent(characters))
            }
        }
    }
}
