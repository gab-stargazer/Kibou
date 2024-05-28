package com.lelestacia.kibou

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lelestacia.kibou.common.Message
import com.lelestacia.kibou.common.route.MainScreen
import com.lelestacia.kibou.common.route.SplashScreen
import com.lelestacia.kibou.common.util.ConnectionManager
import com.lelestacia.kibou.common.util.Logger
import com.lelestacia.kibou.common.util.TestOne
import kotlinx.coroutines.delay
import org.koin.compose.koinInject

@Composable
fun Kibou(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        NavHost(
            navController = navController,
            startDestination = SplashScreen
        ) {
            composable<SplashScreen> {
                val logger = koinInject<Logger>()
                val connectionManager = koinInject<ConnectionManager>()
                LaunchedEffect(key1 = Unit) {
                    TestOne().doSomething()
                    delay(5000)
                    logger.debug(null, Message("Is on wifi: ${connectionManager.isOnWifi()}"))
                    navController.navigate(MainScreen)
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Splash Screen")
                }
            }

            composable<MainScreen> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Main Screen")
                }
            }
        }
    }
}