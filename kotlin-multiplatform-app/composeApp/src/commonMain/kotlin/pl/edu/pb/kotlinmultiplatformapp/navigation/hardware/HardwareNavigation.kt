package pl.edu.pb.kotlinmultiplatformapp.navigation.hardware

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.camera.cameraScreen
import pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.gps.gpsScreen
import pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.sensor.sensorScreen
import pl.edu.pb.kotlinmultiplatformapp.ui.hardware.HardwareScreen

fun NavGraphBuilder.hardwareScreen(navigateTo: (String) -> Unit) {
    composable(Destination.Hardware.route) {
        HardwareScreen(navigateTo = navigateTo)
    }
    cameraScreen()
    gpsScreen()
    sensorScreen(navigateTo)
}
