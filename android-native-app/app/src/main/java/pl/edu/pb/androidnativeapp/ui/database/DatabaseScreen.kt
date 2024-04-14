package pl.edu.pb.androidnativeapp.ui.database

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import pl.edu.pb.androidnativeapp.presentation.database.model.DatabaseState
import pl.edu.pb.androidnativeapp.presentation.database.viewmodel.DatabaseViewModel
import pl.edu.pb.androidnativeapp.ui.Loader

@Composable
fun DatabaseScreen(
    viewModel: DatabaseViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle(DatabaseState.None)

    when (state) {
        is DatabaseState.SavingContent -> SaveScreenContent(state)
        is DatabaseState.RetrievingContent -> RetrieveScreenContent(state)
        DatabaseState.None -> Unit
    }
}

@Composable
private fun SaveScreenContent(state: DatabaseState) {
    if (state is DatabaseState.SavingContent) {
        Box(contentAlignment = Alignment.Center) {
            when {
                state.isLoading -> Loader()
                else -> Button(onClick = state.saveCharacters) {
                    Text(text = "Save")
                }
            }
        }
    }
}

@Composable
fun RetrieveScreenContent(state: DatabaseState) {
    if (state is DatabaseState.RetrievingContent) {
        when {
            state.isLoading -> Loader()
            state.characters.isEmpty() -> Box(contentAlignment = Alignment.Center) {
                Button(onClick = state.getCharacters) {
                    Text(text = "Retrieve")
                }
            }

            else -> LazyColumn {
                items(state.characters) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        AsyncImage(
                            model = it.image,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .clip(RoundedCornerShape(4.dp))
                        )
                        Column {
                            Text(text = it.name)
                            Text(text = it.status)
                            Text(text = it.species)
                            Text(text = it.gender)
                        }
                    }
                }
            }
        }
    }
}
