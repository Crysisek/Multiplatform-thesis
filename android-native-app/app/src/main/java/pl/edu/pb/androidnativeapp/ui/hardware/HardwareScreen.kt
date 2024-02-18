package pl.edu.pb.androidnativeapp.ui.hardware

import androidx.compose.runtime.Composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.ButtonList

@Composable
fun HardwareScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destinations.Hardware.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
