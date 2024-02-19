package pl.edu.pb.androidnativeapp.navigation.hardware.gps

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.hardware.gps.GpsScreen

fun NavGraphBuilder.gpsScreen() {
    composable(Destinations.Hardware.Gps.route) {
        GpsScreen()
    }
}
