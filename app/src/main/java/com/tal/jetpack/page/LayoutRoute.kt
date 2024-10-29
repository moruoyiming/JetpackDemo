package com.tal.jetpack.page

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LayoutRoute() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 45.dp)
        ) {
            BoxDemo()
            RowDemo()
            Filters()
        }
    }
}

@Composable
fun BoxDemo() {
    Box() {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
        )
        Text(
            text = "世界"
        )
    }
}

@Composable
fun RowDemo() {
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 12.dp) // 设置 Surface 的外边距
            .fillMaxWidth(),
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp) // 里面内容的外边距
        ) {
            Text(
                text = "Jetpack Compose 是什么？",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(Modifier.padding(vertical = 5.dp))
            Text(
                text = "Jetpack Compose 是用于构建原生 Android 界面的新工具包。它可简化并加快 Android 上的界面开发，使用更少的代码、强大的工具和直观的 Kotlin API，快速让应用生动而精彩。"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(Icons.Filled.Favorite, null)
                }
                IconButton(
                    onClick = { /*TODO*/ },
                ) {//painterResource(id = R.drawable.ic_launcher_background)
                    Icon(Icons.Filled.AccountCircle, null)
                }
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(Icons.Filled.Share, null)
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Filters() {
    val filters = listOf(
        "Washer/Dryer", "Ramp access", "Garden", "Cats OK", "Dogs OK", "Smoke-free"
    )
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        filters.forEach { title ->
            var selected by remember { mutableStateOf(false) }
            val leadingIcon: @Composable () -> Unit = { Icon(Icons.Default.Check, null) }
            FilterChip(
                selected,
                onClick = { selected = !selected },
                label = { Text(title) },
                leadingIcon = if (selected) leadingIcon else null
            )
        }
    }
}