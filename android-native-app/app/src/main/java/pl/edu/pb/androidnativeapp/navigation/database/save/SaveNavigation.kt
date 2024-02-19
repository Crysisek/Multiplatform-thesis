package pl.edu.pb.androidnativeapp.navigation.database.save

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.database.save.SaveScreen

fun NavGraphBuilder.saveScreen() {
    composable(Destinations.Database.Save.route) {
        SaveScreen()
    }
}
