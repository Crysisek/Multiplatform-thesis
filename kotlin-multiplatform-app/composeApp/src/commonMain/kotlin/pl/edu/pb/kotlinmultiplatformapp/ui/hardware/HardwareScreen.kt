package pl.edu.pb.kotlinmultiplatformapp.ui.hardware

import androidx.compose.runtime.Composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.common.ButtonList

@Composable
fun HardwareScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destination.Hardware.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
