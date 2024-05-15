package pl.edu.pb.kotlinmultiplatformapp.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenSizeInfo(): ScreenSizeInfo = LocalConfiguration.current.run {
    val density = LocalDensity.current

    with(density) {
        ScreenSizeInfo(
            screenHeightPx = screenHeightDp.dp.roundToPx(),
            screenWidthPx = screenWidthDp.dp.roundToPx(),
        )
    }
}
