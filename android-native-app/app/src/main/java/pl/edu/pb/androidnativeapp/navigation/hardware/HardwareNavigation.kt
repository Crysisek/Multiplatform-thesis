package pl.edu.pb.androidnativeapp.navigation.hardware

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.navigation.hardware.camera.cameraScreen
import pl.edu.pb.androidnativeapp.navigation.hardware.gps.gpsScreen
import pl.edu.pb.androidnativeapp.navigation.hardware.sensor.sensorScreen
import pl.edu.pb.androidnativeapp.ui.hardware.HardwareScreen

fun NavGraphBuilder.hardwareScreen(navigateTo: (String) -> Unit) {
    composable(Destination.Hardware.route) {
        HardwareScreen(navigateTo = navigateTo)
    }
    cameraScreen()
    gpsScreen()
    sensorScreen(navigateTo)
}
