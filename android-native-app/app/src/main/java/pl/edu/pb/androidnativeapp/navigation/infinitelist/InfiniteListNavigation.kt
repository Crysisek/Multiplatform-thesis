package pl.edu.pb.androidnativeapp.navigation.infinitelist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.navigation.Destination.Companion.DATA_SOURCE_ARGUMENT
import pl.edu.pb.androidnativeapp.presentation.DataSourceType
import pl.edu.pb.androidnativeapp.ui.infinitelist.InfiniteListScreen
import pl.edu.pb.androidnativeapp.ui.infinitelist.InfiniteListScreenRouter

fun NavGraphBuilder.infiniteListScreen(navigateTo: (String) -> Unit) {
    composable(Destination.InfiniteList.route) {
        it.arguments?.getString(DATA_SOURCE_ARGUMENT).run {
            if (isNullOrEmpty()) {
                InfiniteListScreenRouter(navigateTo = navigateTo)
            } else {
                InfiniteListScreen(DataSourceType.ofParam(this))
            }
        }
    }
}
