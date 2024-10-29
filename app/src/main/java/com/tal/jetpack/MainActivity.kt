package com.tal.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tal.jetpack.page.LayoutRoute
import com.tal.jetpack.page.SplashRoute
import com.tal.jetpack.page.WidgetRoute
import com.tal.jetpack.ui.theme.JetpackDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") {
                    SplashRoute(navController)
                }

                composable("widget") {
                    WidgetRoute()
                }

                composable("layout") {
                    LayoutRoute()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    JetpackDemoTheme {
    }
}




