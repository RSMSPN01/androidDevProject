package com.example.buisnesscard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscard.ui.theme.BuisnessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuisnessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ShowDetails(
                        "Praveen Kumar",
                        "Android Developer",
                        91,
                        123456789,
                        "pk@gmail.com",
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun ShowDetails(
    name: String,
    role: String,
    code: Int,
    mobile: Int,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TopDetails(
            name,
            role,
            Modifier.weight(1f)
        )
        BottomDetail(
            code,
            mobile,
            email,
            Modifier
        )
    }
}

@Composable
fun TopDetails(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .background(color = (Color.Black))
        )
        Text(
            text = name,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = role,
            color = (Color.Green)
        )
    }
}

@Composable
fun BottomDetail(
    code: Int,
    mobile: Int,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(10.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(3.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = "Call Button",
                modifier = Modifier.padding(end = 15.dp)
            )
            Text(
                text = "+" + code + " " + mobile
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(3.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share Button",
                modifier = Modifier.padding(end = 15.dp)
            )
            Text(
                text = "@Android Dev"
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(3.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email Button",
                modifier = Modifier.padding(end = 15.dp)
            )
            Text(
                text = email
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuisnessCardTheme {
        ShowDetails(
            "Praveen Kumar",
            "Developer",
            91,
            123456789,
            "pk@gmail.com",
            modifier = Modifier.fillMaxSize()
        )
    }
}