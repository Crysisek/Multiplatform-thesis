package pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.gps

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.compose.koinInject
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.HardwareUIFactory

fun NavGraphBuilder.gpsScreen() {
    composable(Destination.Hardware.Gps.route) {
        koinInject<HardwareUIFactory>().GpsScreen()
    }
}
