package com.tal.jetpack.ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            // 测量每个子元素，我们修改了最小的宽高为0
            // 这是因为，当父元素被设置为 fillMaxSize 时，constraints.maxWidth 与 constraints.maxHeight 会被设置为 Int.MAX_VALUE
            // 而我们的子元素并不需要也占据满父元素，所以我们将最小宽高设置为0
            measurable.measure(constraints.copy(minWidth = 0, minHeight = 0))
        }
        var yPosition = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach { placeable ->
                // placeRelative 会根据当前 layoutDirection 自动调整子元素的位置（从左至右或从右至左）
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }
    }
}