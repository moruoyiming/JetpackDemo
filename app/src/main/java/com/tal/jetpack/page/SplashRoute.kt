package com.tal.jetpack.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SplashRoute(navController: NavHostController) {
    SplashScreen(navController)
}

@Composable
fun SplashScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(45.dp)
            ) {
                Text(
                    "JetPack Demo",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(5.dp),
                )
                Button(
                    onClick = {
                        navController.navigate("widget")
                    },
                    shape = ButtonDefaults.shape,
                ) {
                    Text("Widget Demo")
                }
                Button(
                    onClick = {
                        navController.navigate("layout")
                    },
                    shape = ButtonDefaults.shape,
                ) {
                    Text("Layout Demo")
                }
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
//    SplashScreen()
}