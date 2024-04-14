package pl.edu.pb.androidnativeapp.navigation.database

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.database.DatabaseScreen

fun NavGraphBuilder.databaseScreen() {
    composable(Destination.Database.route) {
        DatabaseScreen()
    }
}
