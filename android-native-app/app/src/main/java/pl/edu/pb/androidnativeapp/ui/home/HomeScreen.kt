package pl.edu.pb.androidnativeapp.ui.home

import androidx.compose.runtime.Composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.common.ButtonList

@Composable
fun HomeScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destination.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
