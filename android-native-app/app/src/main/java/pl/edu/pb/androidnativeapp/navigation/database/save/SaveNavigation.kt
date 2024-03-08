package pl.edu.pb.androidnativeapp.navigation.database.save

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.database.save.SaveScreen

fun NavGraphBuilder.saveScreen() {
    composable(Destination.Database.Save.route) {
        SaveScreen()
    }
}
