package pl.edu.pb.kotlinmultiplatformapp.navigation.animation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.animation.AnimationScreen

fun NavGraphBuilder.animationScreen() {
    composable(Destination.Animation.route) {
        AnimationScreen()
    }
}
