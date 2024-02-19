package pl.edu.pb.androidnativeapp.navigation.infinitelist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.presentation.DataSourceType
import pl.edu.pb.androidnativeapp.ui.infinitelist.InfiniteListScreen
import pl.edu.pb.androidnativeapp.ui.infinitelist.InfiniteListScreenRouter

fun NavGraphBuilder.infiniteListScreen(navigateTo: (String) -> Unit) {
    composable(Destinations.InfiniteList.routeWithArgument) {
        it.arguments?.getString("data_source_type").run {
            if (isNullOrEmpty()) {
                InfiniteListScreenRouter(navigateTo = navigateTo)
            } else {
                InfiniteListScreen(DataSourceType.ofParam(this))
            }
        }
    }
}
