package pl.edu.pb.androidnativeapp.navigation.database.retrieve

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.database.retrieve.RetrieveScreen

fun NavGraphBuilder.retrieveScreen() {
    composable(Destinations.Database.Retrieve.route) {
        RetrieveScreen()
    }
}
