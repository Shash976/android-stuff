package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}


@Composable
fun WeeklySpecial(){
    // to be defined
    Card(Modifier.fillMaxWidth()) {
        Text(text = "Weekly Special", fontSize = 26.sp, modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold)
    }
}


@Composable
fun MenuDish() {
    // to be defined
    Card() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            Column() {
                Text("Greek Salad", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...", color = Color.Gray, modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth(.75f))
                Text("$12.99", color=Color.Gray, fontWeight = FontWeight.Bold)
            }
            Image(painter = painterResource(id = R.drawable.greeksalad), contentDescription = "Greek Salad Image")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
