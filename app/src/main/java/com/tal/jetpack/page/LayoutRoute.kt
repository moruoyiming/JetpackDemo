package com.tal.jetpack.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberModalBottomSheetState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.tal.jetpack.R
import kotlinx.coroutines.launch

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
            SurfaceDemo()
            SpacerDemo()
            ModalBottomSheetLayoutDemo()
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

@Composable
fun SurfaceDemo() {
    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 2.dp,
        modifier = Modifier
            .width(300.dp)
            .height(100.dp)
    ) {
        Row(modifier = Modifier.clickable { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.description),
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.padding(horizontal = 12.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Liratie",
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(Modifier.padding(vertical = 8.dp))
                Text(
                    text = "礼谙"
                )
            }
        }
    }
}

@Composable
fun SpacerDemo() {
    Row {
        Box(Modifier.size(100.dp).background(Color.Red))
        Spacer(Modifier.width(20.dp))
        Box(Modifier.size(100.dp).background(Color.Magenta))
        Spacer(Modifier.weight(1f))
        Box(Modifier.size(100.dp).background(Color.Black))
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheetLayoutDemo(){
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    Column {
        ModalBottomSheetLayout(
            sheetState = state,
            sheetContent = {
                Column{
                    ListItem(
                        text = { Text("选择分享到哪里吧~") }
                    )

                    ListItem(
                        text = { Text("github") },
                        icon = {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFF181717)
                            ) {
                                Icon(
                                    painterResource(R.drawable.ic_launcher_background),
                                    null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(4.dp)
                                )
                            }
                        },
                        modifier = Modifier.clickable {  }
                    )

                    ListItem(
                        text = { Text("微信") },
                        icon = {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFF07C160)
                            ) {
                                Icon(
                                    painterResource(R.drawable.ic_launcher_background),
                                    null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(4.dp)
                                )
                            }
                        },
                        modifier = Modifier.clickable {  }
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { scope.launch { state.show() } }
                ) {
                    Text("点我展开")
                }
            }
        }
    }
}

@Composable
fun PageDemo(){

}