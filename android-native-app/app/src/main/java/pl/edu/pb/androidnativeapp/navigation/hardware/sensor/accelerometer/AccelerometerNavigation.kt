package pl.edu.pb.androidnativeapp.navigation.hardware.sensor.accelerometer

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.hardware.sensor.accelerometer.AccelerometerScreen

fun NavGraphBuilder.accelerometerScreen() {
    composable(Destination.Hardware.Sensor.Accelerometer.route) {
        AccelerometerScreen()
    }
}
