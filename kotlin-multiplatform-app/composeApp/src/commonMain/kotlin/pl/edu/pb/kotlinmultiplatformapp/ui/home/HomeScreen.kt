package pl.edu.pb.kotlinmultiplatformapp.ui.home

import androidx.compose.runtime.Composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.common.ButtonList

@Composable
fun HomeScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destination.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
