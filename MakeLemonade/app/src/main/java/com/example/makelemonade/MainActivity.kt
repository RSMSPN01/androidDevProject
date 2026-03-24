package com.example.makelemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeMaker();
        }
    }
}

// Although it seems to work perfectly fine, but we are making
// the state change based on the UI directly and if we miss out
// any file whole app is going to crash, which is not a good practice
// to have so change the value based on states not UI directly.
@Composable
fun MakeLemonade(modifier: Modifier = Modifier) {
    // Column is the parent box
    var displayText by remember { mutableStateOf(R.string.tap_lemon_tree) }
    var count by remember { mutableStateOf(0) }
    // in start of the app this is the constant value
    var newImage by remember { mutableStateOf(R.drawable.lemon_tree) }
    fun updateImage() {
        if (newImage == R.drawable.lemon_tree) {
            newImage = R.drawable.lemon_squeeze
            displayText = R.string.squeeze_lemon
            count = (2..4).random();
        } else if (newImage == R.drawable.lemon_squeeze) {
            if (count > 1) {
                count--;
            } else {
                newImage = R.drawable.lemon_drink
                displayText = R.string.tap_lemonade
            }
        } else if (newImage == R.drawable.lemon_drink) {
            newImage = R.drawable.lemon_restart
            displayText = R.string.tap_empty_glass
        } else {
            newImage = R.drawable.lemon_tree
            displayText = R.string.tap_lemon_tree
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Lemonade",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .background(Color.Yellow)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painterResource(newImage),
                contentDescription = "LemonTree",
                modifier = Modifier.clickable {
                    updateImage()
                }

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                stringResource(displayText),
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeMaker() {
    MakeLemonade(modifier = Modifier.fillMaxSize())
}