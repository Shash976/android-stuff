package com.example.littlelemon

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navController = navController)}) {
        Box(Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = Home.route) {
                composable(Home.route){
                    HomeScreen(navController)
                }
                composable(Location.route) {
                    LocationScreen()
                }
                composable(Menu.route){
                    MenuScreen()
                }
            }
        }
    }
}
@Composable
fun MyBottomNavigation(navController: NavController) {
    val destinations = listOf<Destinations>(
        Home,
        Menu,
        Location
    )
    var selectedIndex = rememberSaveable { mutableStateOf(0) }
    BottomNavigation(){
        destinations.forEachIndexed { index, destination ->
            BottomNavigationItem(
                label = {Text(destination.title)},
                icon = { Image(painter = painterResource(id = destination.icon), contentDescription = destination.title)},
                selected = index==selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinations[index].route){
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview(){
    LittleLemonTheme {
        App()
    }
}