package pl.edu.pb.androidnativeapp.navigation.hardware.nfc

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.hardware.nfc.NfcScreen

fun NavGraphBuilder.nfcScreen() {
    composable(Destination.Hardware.Nfc.route) {
        NfcScreen()
    }
}
