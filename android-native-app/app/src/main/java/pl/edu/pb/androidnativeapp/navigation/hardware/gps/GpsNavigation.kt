package pl.edu.pb.androidnativeapp.navigation.hardware.gps

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.hardware.gps.GpsScreen

fun NavGraphBuilder.gpsScreen() {
    composable(Destination.Hardware.Gps.route) {
        GpsScreen()
    }
}
