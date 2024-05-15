package pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.sensor.light

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.compose.koinInject
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.HardwareUIFactory

fun NavGraphBuilder.lightScreen() {
    composable(Destination.Hardware.Sensor.Light.route) {
        koinInject<HardwareUIFactory>().LightScreen()
    }
}
