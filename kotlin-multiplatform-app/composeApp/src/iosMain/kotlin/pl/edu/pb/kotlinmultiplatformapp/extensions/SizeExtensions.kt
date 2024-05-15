package pl.edu.pb.kotlinmultiplatformapp.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenSizeInfo(): ScreenSizeInfo = LocalWindowInfo.current.run {
    ScreenSizeInfo(
        screenHeightPx = containerSize.height,
        screenWidthPx = containerSize.width,
    )
}
