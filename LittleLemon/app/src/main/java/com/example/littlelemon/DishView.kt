package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.body1
import com.example.littlelemon.ui.theme.h1
import com.example.littlelemon.ui.theme.h2

@Composable
fun DishView(dishID :Int){
    val dish = requireNotNull(DishRepository.getDish(dishID))
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(10.dp)
    ) {
        TopAppBar()
        Image(
            painter = painterResource(id = dish.imageResource),
            contentDescription = dish.name,
            modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Column {
            Text(dish.name, style= h1)
            Text(text = dish.description, style = body1)
            Button(
                onClick = {}
            ){
                Text(text = stringResource(id = R.string.add_for) + " $${dish.price}", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
            Counter()
        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        var counter by remember {
            mutableStateOf(0)
        }
        TextButton(
            onClick = {
                if (counter != 0) {
                    counter--
                }
                else {
                    counter = 0
                }

            }
        ) {
            Text(
                text = "-",
                style = h2
            )
        }
        Text(
            text = counter.toString(),
            style = h2,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = h2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DishViewPreview(){
    DishView(dishID = 5)
}