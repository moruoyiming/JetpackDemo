package com.tal.jetpack.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tal.jetpack.R
import com.tal.jetpack.ui.theme.JetpackDemoTheme
import com.tal.jetpack.ui.widget.ButtonState
import com.tal.jetpack.ui.widget.MyIconButton

@Composable
fun WidgetRoute(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(45.dp)) {
            Greeting(
                name = "Android", modifier = Modifier.padding(10.dp)
            )
            TextDemo()
            TextFieldDemo()
            ButtonDemo()
            CardDemo()
            ActionButtonDemo()
            IconDemo()
            IconButtonDemo()
            CustomIconButtonDemo()
            ImageDemo()
            SlideDemo()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.Center) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
        )
    }
}

@Composable
fun TextDemo() {
    Text(stringResource(id = R.string.content))
}

@Composable
fun TextFieldDemo() {
    var text by remember{ mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        label = {
            Text("邮箱")
        }
    )
}

@Composable
fun ButtonDemo() {
    Button(
        onClick = {
//            Toast.makeText(context, "Button", Toast.LENGTH_LONG).show()
        },
        shape = ButtonDefaults.shape,
    ) {
        Text("Button")
    }
    Button(onClick = {
//        Toast.makeText(context, "IconButton", Toast.LENGTH_LONG).show()
    }) {
        Icon(
            Icons.Filled.Favorite, contentDescription = null, modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("喜欢")
    }
    // 获取按钮的状态
    val interactionState = remember { MutableInteractionSource() }
    // 使用 Kotlin 的解构方法
    val (text, textColor, buttonColor) = when {
        interactionState.collectIsPressedAsState().value -> ButtonState("Just Pressed", Color.Red, Color.Black)
        else -> ButtonState("Just Button", Color.White, Color.Red)
    }
    Button(
        onClick = { /*TODO*/ },
        interactionSource = interactionState,
        elevation = null,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(),
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .height(IntrinsicSize.Min)
    ) {
        Text(
            text = text, color = textColor
        )
    }
}

@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { }, elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
    ) {
        Text(buildAnnotatedString {
            append("欢迎来到 ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))) {
                append("Jetpack Compose 博物馆")
            }
        })
        Text(buildAnnotatedString {
            append("你现在观看的章节是 ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                append("Card")
            }
        })
    }
}

@Composable
fun ActionButtonDemo() {
    ExtendedFloatingActionButton(
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        text = { Text("添加到我喜欢的") },
        onClick = { /*do something*/ }
    )
}

@Composable
fun IconDemo() {
    Icon(
        imageVector = Icons.Filled.Favorite,
        contentDescription = null,
        tint = Color.Red,
    )
}

@Composable
fun IconButtonDemo() {
    Row {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Search, null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.ArrowBack, null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Done, null)
        }
    }
}

@Composable
fun CustomIconButtonDemo() {
    Row {
        MyIconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Search, null)
        }
    }
}

@Composable
fun ImageDemo() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = null,
        modifier = Modifier.size(50.dp)
    )

    Surface(
        shape = CircleShape,
        border = BorderStroke(2.dp, Color.Cyan)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SlideDemo(){
    var progress by remember{ mutableStateOf(0f) }
    Slider(
        value = progress,
        colors = SliderDefaults.colors(
            thumbColor = Color.White, // 圆圈的颜色
            activeTrackColor = Color(0xFF0079D3)
        ),
        onValueChange = {
            progress = it
        },
    )
}


@Preview(showBackground = true)
@Composable
fun WidgetPreview() {
    JetpackDemoTheme {
        Greeting("Android")
    }
}