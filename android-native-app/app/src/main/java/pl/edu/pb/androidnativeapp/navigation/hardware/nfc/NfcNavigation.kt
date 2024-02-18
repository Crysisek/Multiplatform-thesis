package pl.edu.pb.androidnativeapp.navigation.hardware.nfc

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.hardware.nfc.NfcScreen

fun NavGraphBuilder.nfcScreen() {
    composable(Destinations.Hardware.Nfc.route) {
        NfcScreen()
    }
}
