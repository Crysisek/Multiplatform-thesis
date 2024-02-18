package pl.edu.pb.androidnativeapp.ui.infinitelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.presentation.DataSourceType

@Composable
fun InfiniteListScreenRouter(navigateTo: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DataSourceType.entries.forEach {
            Button(onClick = { navigateTo(Destinations.InfiniteList.routeWithArgument.replaceAfter('=', it.param)) }) {
                Text(text = it.name)
            }
        }
    }
}

@Composable
fun InfiniteListScreen(dataSourceType: DataSourceType) {
    Text(text = "TODO $dataSourceType")
}
