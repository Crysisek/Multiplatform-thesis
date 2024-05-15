package pl.edu.pb.kotlinmultiplatformapp.navigation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.navigation.animation.animationScreen
import pl.edu.pb.kotlinmultiplatformapp.navigation.database.databaseScreen
import pl.edu.pb.kotlinmultiplatformapp.navigation.filedecoding.fileDecodingScreen
import pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.hardwareScreen
import pl.edu.pb.kotlinmultiplatformapp.navigation.infinitelist.infiniteListScreen
import pl.edu.pb.kotlinmultiplatformapp.ui.home.HomeScreen

fun NavGraphBuilder.homeScreen(navigateTo: (String) -> Unit) {
    composable(Destination.Home.route) {
        HomeScreen(navigateTo = navigateTo)
    }
    infiniteListScreen(navigateTo = navigateTo)
    hardwareScreen(navigateTo = navigateTo)
    databaseScreen()
    animationScreen()
    fileDecodingScreen()
}
