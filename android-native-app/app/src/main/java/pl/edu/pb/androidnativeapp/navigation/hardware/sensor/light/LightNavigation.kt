package pl.edu.pb.androidnativeapp.navigation.hardware.sensor.light

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.hardware.sensor.light.LightScreen

fun NavGraphBuilder.lightScreen() {
    composable(Destination.Hardware.Sensor.Light.route) {
        LightScreen()
    }
}
