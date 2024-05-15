package pl.edu.pb.kotlinmultiplatformapp.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

@Composable
actual fun <T> Flow<T>.collectAsStateMultiplatform(
    initialValue: T,
    context: CoroutineContext,
): State<T> = collectAsStateWithLifecycle(initialValue, context = context)
