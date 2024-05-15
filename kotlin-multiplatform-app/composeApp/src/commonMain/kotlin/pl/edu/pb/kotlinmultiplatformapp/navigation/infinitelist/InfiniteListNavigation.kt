package pl.edu.pb.kotlinmultiplatformapp.navigation.infinitelist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination.Companion.DATA_SOURCE_ARGUMENT
import pl.edu.pb.kotlinmultiplatformapp.presentation.DataSourceType
import pl.edu.pb.kotlinmultiplatformapp.ui.infinitelist.InfiniteListScreen
import pl.edu.pb.kotlinmultiplatformapp.ui.infinitelist.InfiniteListScreenRouter

fun NavGraphBuilder.infiniteListScreen(navigateTo: (String) -> Unit) {
    composable(Destination.InfiniteList.route) {
        InfiniteListScreenRouter(navigateTo = navigateTo)
    }
    composable(Destination.InfiniteList.localRoute) {
        InfiniteListScreen(DataSourceType.LOCAL)
    }
    composable(Destination.InfiniteList.networkRoute) {
        InfiniteListScreen(DataSourceType.NETWORK)
    }
}
