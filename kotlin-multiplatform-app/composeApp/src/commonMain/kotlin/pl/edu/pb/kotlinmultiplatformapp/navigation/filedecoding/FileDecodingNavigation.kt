package pl.edu.pb.kotlinmultiplatformapp.navigation.filedecoding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.filedecoding.FileDecodingScreen

fun NavGraphBuilder.fileDecodingScreen() {
    composable(Destination.FileDecoding.route) {
        FileDecodingScreen()
    }
}
