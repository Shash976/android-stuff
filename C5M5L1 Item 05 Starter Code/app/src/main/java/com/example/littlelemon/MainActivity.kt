package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                val dishIDs = DishRepository.getRangeOfID()
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Home.route) {
                        HomeScreen(navController)
                    }
                    for (dishID in dishIDs){
                        composable(
                            DishDetails.route + "/{${dishID}}",
                        ) {
                            DishDetails(dishID)
                        }
                    }
                }
            }
        }
    }
}
