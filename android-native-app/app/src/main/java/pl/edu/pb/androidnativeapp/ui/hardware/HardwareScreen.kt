package pl.edu.pb.androidnativeapp.ui.hardware

import androidx.compose.runtime.Composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.common.ButtonList

@Composable
fun HardwareScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destination.Hardware.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
