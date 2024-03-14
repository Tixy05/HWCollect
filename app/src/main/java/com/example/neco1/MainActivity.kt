package com.example.neco1

import android.os.Bundle
import android.support.v4.os.IResultReceiver.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.neco1.ui.theme.Neco1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Neco1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        itemsIndexed(listOf("a", "b", "c")) { index, item ->
                            CarCard()
                        }
                    }
                    Box(modifier = Modifier.offset(x = 100.dp, y = 100.dp).size(10.dp).background(color = Color.Red, shape = CircleShape).c) {

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    Neco1Theme {
        Greeting("Android")
    }
}

val testCar = Car (
    manufacturer = "Volkswagen",
    model = "Golf",
    year = 1989,
    rarity = Rarity.RARE,
    isPremium = false,
    colors = listOf(0xffffff00, 0xff000000, 0xff505050),
)

@Preview(showBackground = true)
@Composable
fun CarCard(car: Car = testCar) {
    Box(modifier = Modifier
//        .padding(10.dp)
        .background(Color.White)
        .fillMaxWidth()
        .height(50.dp),
        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(10.dp)
                    .background(
                        when (car.rarity) {
                            Rarity.COMMON -> Color.Gray
                            Rarity.RARE -> Color.Cyan
                            Rarity.EPIC -> Color.Magenta
                            Rarity.LEGENDARY -> Color.Yellow
                            Rarity.SPECIAL -> Color.Red
                        }
                    )

            )
            Column(modifier = Modifier.padding(4.dp)) {
                val year: String = if (car.year != null) {
                    "'" + car.year.toString().substring(2) + " "
                } else {
                    ""
                }
                Text(text = "$year${car.manufacturer} ${car.model}",
                    fontSize = 16.sp)
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = if (car.isPremium) "Premium" else "Common",
                        color = Color.Gray,
                        fontSize = 11.sp)
                    ColorCircles(colors = car.colors, circleSize = 10.dp)
                }
            }
        }
    }
}

@Composable
fun ColorCircles(colors: List<Long>, circleSize: Dp) {
    Row(modifier = Modifier.width(colors.size * 1.2 * circleSize),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        for (color in colors) {
            Box(modifier = Modifier
                .background(color = Color(color), shape = CircleShape)
                .border(BorderStroke(1.dp, Color.Black), CircleShape)
                .size(circleSize)
            )
        }
    }
}