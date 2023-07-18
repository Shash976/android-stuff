package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                val dishIDs = DishRepository.getRangeOfID()
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Home.route){
                        HomeScreen(navController)
                    }
                    dishIDs.forEach{dishID -> 
                        composable(Menu.route + "/${dishID}"){
                            DishView(dishID = dishID)
                        }
                    }
                }
            }
        }
    }
}
