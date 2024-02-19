package pl.edu.pb.androidnativeapp.navigation.filedecoding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.filedecoding.FileDecodingScreen

fun NavGraphBuilder.fileDecodingScreen() {
    composable(Destinations.FileDecoding.route) {
        FileDecodingScreen()
    }
}
