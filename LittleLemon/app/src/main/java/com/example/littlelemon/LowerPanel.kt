package com.example.littlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.body1
import com.example.littlelemon.ui.theme.body2
import com.example.littlelemon.ui.theme.h1
import com.example.littlelemon.ui.theme.h2


@Composable
fun LowerPanel(navController: NavController?){
    Column {
        WeeklySpecialCard()
        LazyColumn(){
            itemsIndexed(DishRepository.dishes){_,dish ->
                dishCard(dish = dish, navController)
            }
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.weekly_special),
            style = h1,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dishCard(dish: Dish, navController: NavController?) {
    Card (
        onClick = {
            Log.d("AAA", "Click ${dish.id}")
            navController?.navigate(Menu.route + "/${dish.id}")
        }
            ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column() {
                Text(text = dish.name, style = h2)
                Text(dish.description, style=body1, modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(top = 5.dp, bottom = 5.dp) )
                Text(text = "$${ dish.price }", style = body2)
            }
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = dish.name,
                modifier = Modifier
                    .clip(RoundedCornerShape(7.dp))
                    .padding(start = 2.dp)
            )
        }
        Divider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 1.dp,
            color = LittleLemonColor.yellow
        )
    }
}
/*
@Preview(showBackground = true)
@Composable
fun DishCardPreview(){
    LowerPanel()
}
*/
