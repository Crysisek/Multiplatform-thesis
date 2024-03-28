package pl.edu.pb.androidnativeapp.navigation.hardware.sensor

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.navigation.hardware.sensor.accelerometer.accelerometerScreen
import pl.edu.pb.androidnativeapp.navigation.hardware.sensor.light.lightScreen
import pl.edu.pb.androidnativeapp.ui.hardware.sensor.SensorScreen

fun NavGraphBuilder.sensorScreen(navigateTo: (String) -> Unit) {
    composable(Destination.Hardware.Sensor.route) {
        SensorScreen(navigateTo)
    }
    accelerometerScreen()
    lightScreen()
}
