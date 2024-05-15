package pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.sensor

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.sensor.accelerometer.accelerometerScreen
import pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.sensor.light.lightScreen
import pl.edu.pb.kotlinmultiplatformapp.ui.hardware.sensor.SensorScreen

fun NavGraphBuilder.sensorScreen(navigateTo: (String) -> Unit) {
    composable(Destination.Hardware.Sensor.route) {
        SensorScreen(navigateTo)
    }
    accelerometerScreen()
    lightScreen()
}
