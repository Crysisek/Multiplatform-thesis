package pl.edu.pb.kotlinmultiplatformapp.ui.infinitelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import pl.edu.pb.kotlinmultiplatformapp.ui.Loader
import pl.edu.pb.kotlinmultiplatformapp.extensions.collectAsStateMultiplatform
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.presentation.DataSourceType
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.model.InfiniteListState
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.model.InfiniteListState.Content
import pl.edu.pb.kotlinmultiplatformapp.presentation.infinitelist.viewmodel.InfiniteListViewModel

@Composable
fun InfiniteListScreenRouter(navigateTo: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DataSourceType.entries.forEach {
            Button(onClick = { navigateTo(Destination.InfiniteList.passArgument(it.param)) }) {
                Text(text = it.name)
            }
        }
    }
}

@Composable
fun InfiniteListScreen(
    dataSourceType: DataSourceType,
    viewModel: InfiniteListViewModel = koinInject {
        parametersOf(dataSourceType)
    },
) {
    val state by viewModel.state.collectAsStateMultiplatform(InfiniteListState.None)

    when (state) {
        is Content -> InfiniteListContent(state)
        InfiniteListState.None -> Loader()
    }
}

@Composable
fun InfiniteListContent(state: InfiniteListState) {
    if (state is Content) {
        val lazyListState = rememberLazyListState()
        val isScrolledToEnd by remember {
            derivedStateOf {
                lazyListState.isScrolledToEnd()
            }
        }
        LaunchedEffect(isScrolledToEnd) {
            if (isScrolledToEnd) {
                state.loadMoreCharacters()
            }
        }
        LazyColumn(state = lazyListState) {
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
            item {
                Loader()
            }
        }
    }
}

fun LazyListState.isScrolledToEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
