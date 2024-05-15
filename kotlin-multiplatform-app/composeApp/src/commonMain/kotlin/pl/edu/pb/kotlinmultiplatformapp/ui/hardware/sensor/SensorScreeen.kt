package pl.edu.pb.kotlinmultiplatformapp.ui.hardware.sensor

import androidx.compose.runtime.Composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.common.ButtonList

@Composable
fun SensorScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destination.Hardware.Sensor.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
