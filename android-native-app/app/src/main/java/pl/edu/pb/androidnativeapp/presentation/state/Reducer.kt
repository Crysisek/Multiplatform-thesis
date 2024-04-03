package pl.edu.pb.androidnativeapp.presentation.state

import kotlinx.coroutines.flow.Flow

interface Reducer<S : State, A : Action> {

    val state: Flow<S>

    suspend fun update(action: A)
}
