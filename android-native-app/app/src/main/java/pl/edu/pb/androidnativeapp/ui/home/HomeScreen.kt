package pl.edu.pb.androidnativeapp.ui.home

import androidx.compose.runtime.Composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.ButtonList

@Composable
fun HomeScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destinations.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
