package pl.edu.pb.androidnativeapp.ui.hardware.sensor

import androidx.compose.runtime.Composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.common.ButtonList

@Composable
fun SensorScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destination.Hardware.Sensor.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
