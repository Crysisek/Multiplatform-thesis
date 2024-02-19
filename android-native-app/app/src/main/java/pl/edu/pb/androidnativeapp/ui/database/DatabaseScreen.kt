package pl.edu.pb.androidnativeapp.ui.database

import androidx.compose.runtime.Composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.ButtonList

@Composable
fun DatabaseScreen(navigateTo: (String) -> Unit) {
    ButtonList(
        destinations = Destinations.Database.testSubjectDestinations,
        navigateTo = navigateTo,
    )
}
