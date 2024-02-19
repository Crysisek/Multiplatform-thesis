package pl.edu.pb.androidnativeapp.navigation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.navigation.animation.animationScreen
import pl.edu.pb.androidnativeapp.navigation.database.databaseScreen
import pl.edu.pb.androidnativeapp.navigation.filedecoding.fileDecodingScreen
import pl.edu.pb.androidnativeapp.navigation.hardware.hardwareScreen
import pl.edu.pb.androidnativeapp.navigation.infinitelist.infiniteListScreen
import pl.edu.pb.androidnativeapp.ui.home.HomeScreen

fun NavGraphBuilder.homeScreen(navigateTo: (String) -> Unit) {
    composable(Destinations.Home.route) {
        HomeScreen(navigateTo = navigateTo)
    }
    infiniteListScreen(navigateTo = navigateTo)
    hardwareScreen(navigateTo = navigateTo)
    databaseScreen(navigateTo = navigateTo)
    animationScreen()
    fileDecodingScreen()
}
