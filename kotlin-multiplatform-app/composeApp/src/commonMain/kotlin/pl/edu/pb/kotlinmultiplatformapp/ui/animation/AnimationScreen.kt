package pl.edu.pb.kotlinmultiplatformapp.ui.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import pl.edu.pb.kotlinmultiplatformapp.extensions.getScreenSizeInfo

@Composable
fun AnimationScreen() {
    val color by animateColorBetween(Color.Red, Color.Magenta)
    val rectSize = 100.dp
    val density = LocalDensity.current
    val screenHeightPx = getScreenSizeInfo().screenHeightPx
    val rectHeightPx = with(density) { rectSize.roundToPx() }
    val offset by animateValueBetween((screenHeightPx - rectHeightPx) / 2, -100)

    Box(contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(rectSize)
                .offset {
                    IntOffset(0, offset.toInt())
                }
                .drawBehind {
                    drawRect(color)
                }
        )
    }
}

@Composable
fun animateColorBetween(start: Color, end: Color): State<Color> {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    return infiniteTransition.animateColor(
        initialValue = start,
        targetValue = end,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "",
    )
}

@Composable
fun animateValueBetween(start: Int, end: Int): State<Float> {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    return infiniteTransition.animateFloat(
        initialValue = start.toFloat(),
        targetValue = end.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "",
    )
}
