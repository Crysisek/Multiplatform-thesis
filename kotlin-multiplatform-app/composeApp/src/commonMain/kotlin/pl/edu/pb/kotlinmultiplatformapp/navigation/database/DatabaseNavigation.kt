package pl.edu.pb.kotlinmultiplatformapp.navigation.database

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.database.DatabaseScreen

fun NavGraphBuilder.databaseScreen() {
    composable(Destination.Database.route) {
        DatabaseScreen()
    }
}
