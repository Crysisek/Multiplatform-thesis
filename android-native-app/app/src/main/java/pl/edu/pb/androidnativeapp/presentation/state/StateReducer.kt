package pl.edu.pb.androidnativeapp.presentation.state

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

abstract class StateReducer<STATE : State, ACTION : Action>(
    initialState: STATE,
) : Reducer<STATE, ACTION> {

    private val _state = MutableStateFlow(initialState)
    private val mutex by lazy { Mutex() }

    final override val state: StateFlow<STATE>
        get() = _state

    final override suspend fun update(action: ACTION) {
        mutex.withLock {
            withContext(Dispatchers.Default) {
                val newState = reduce(action, state.value)
                _state.value = newState
            }
        }
    }

    protected abstract fun reduce(action: ACTION, currentState: STATE): STATE
}
