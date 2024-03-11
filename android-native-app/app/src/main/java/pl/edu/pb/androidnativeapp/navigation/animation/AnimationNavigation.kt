package pl.edu.pb.androidnativeapp.navigation.animation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.animation.AnimationScreen

fun NavGraphBuilder.animationScreen() {
    composable(Destination.Animation.route) {
        AnimationScreen()
    }
}
