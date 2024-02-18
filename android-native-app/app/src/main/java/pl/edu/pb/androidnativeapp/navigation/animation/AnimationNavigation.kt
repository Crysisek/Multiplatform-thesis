package pl.edu.pb.androidnativeapp.navigation.animation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.ui.animation.AnimationScreen

fun NavGraphBuilder.animationScreen() {
    composable(Destinations.Animation.route) {
        AnimationScreen()
    }
}
