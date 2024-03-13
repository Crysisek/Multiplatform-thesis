package pl.edu.pb.androidnativeapp.navigation.filedecoding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.filedecoding.FileDecodingScreen

fun NavGraphBuilder.fileDecodingScreen() {
    composable(Destination.FileDecoding.route) {
        FileDecodingScreen()
    }
}
