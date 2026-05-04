package com.example.legendsgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.legendsgallery.ui.theme.LegendsGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LegendsGalleryTheme {
                MainScreenContent(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun DisplayImage(
    modifier: Modifier,
    image: Int
) {
    Image(
        painterResource(image),
        contentDescription = null,
        Modifier
            .height(400.dp)
            .width(400.dp)
    )
}

@Composable
fun DisplayText(
    modifier: Modifier,
    @StringRes service: Int
) {
    Text(
        text = stringResource(service),
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DisplayButton(
    modifier: Modifier,
    type: String,
    update: () -> Unit
) {
    Button(onClick = update) {
        Text(type)
    }
}

@Composable
fun MainScreenContent(
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        var image by remember { mutableStateOf(R.drawable.captain_vikram_batra) }
        var name by remember { mutableStateOf(R.string.captain_vikram_batra) }
        var service by remember { mutableStateOf(R.string.captain_vikram_batra_service) }
        var counter by remember { mutableStateOf(1) }
        // instead of else if it can done with when as well
        if (counter == 1) {
            image = R.drawable.captain_vikram_batra
            service = R.string.captain_vikram_batra_service
            name = R.string.captain_vikram_batra
        } else if (counter == 2) {
            image = R.drawable.captain_saurabh_kalia
            service = R.string.captain_sourabh_kalia_service
            name = R.string.captain_sourabh_kalia
        } else if (counter == 3) {
            image = R.drawable.major_sudhir_kumar_walia
            service = R.string.major_sudhir_walia_service
            name = R.string.major_sudhir_walia
        } else if (counter >= 4) {
            //reset
            counter = 1;
            image = R.drawable.captain_vikram_batra
            service = R.string.captain_vikram_batra_service
            name = R.string.captain_vikram_batra
        } else {
            // again reset from the back
            counter = 3
            image = R.drawable.major_sudhir_kumar_walia
            service = R.string.major_sudhir_walia_service
            name = R.string.major_sudhir_walia
        }
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
        ) {
            Text(
                text = "Fallen Heros (Legends)",
                fontSize = 30.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.padding(16.dp))
        DisplayImage(
            modifier,
            image
        )
        Spacer(Modifier.padding(16.dp))
        DisplayText(
            modifier,
            name
        )
        DisplayText(
            modifier,
            service
        )
        Spacer(Modifier.padding(16.dp))
        Row(
            modifier = Modifier
        ) {
            DisplayButton(
                modifier,
                "Previous",
                { counter = counter - 1 })
            // counter values can be even more well defined
            Spacer(Modifier.padding(horizontal = 25.dp))
            DisplayButton(
                modifier,
                "Next",
                { counter = counter + 1 })
        }
    }
}
// project done
@Preview(showBackground = true)
@Composable
fun DisplayHeors() {
    MainScreenContent(modifier = Modifier.fillMaxSize())
}