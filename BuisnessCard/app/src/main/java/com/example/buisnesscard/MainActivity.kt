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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
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
                    DisplayDetails(
                        "Praveen Kumar",
                        "Android developer Extraordinary",
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                    ContactDetails(
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
fun ContactDetails(
    countryCode: Int,
    mobileNumber: Long,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                5.dp,

            )
        ) {
            Icon(
                Icons.Rounded.Call,
                contentDescription = "null",

                )
            Text(
                text = "+$countryCode $mobileNumber",
                color = Color(0xFF295e44)
            )
        }
        Row(modifier = Modifier.padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "null"
            )
            Text(
                text = "@Android Dev",
                color = Color(0xFF295e44)
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "null"
            )
            Text(
                text = email,
                color = Color(0xFF295e44)
            )
        }
    }
}

@Composable
fun DisplayDetails(
    name: String,
    jobRole: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .background(color = Color(0xFF182c36))
        )
        Text(
            text = name,
            fontSize = 35.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = jobRole,
            color = Color(0xFF295e44)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuisnessCardTheme {
        ContactDetails(
            91,
            123456789,
            "pk@gmail.com",
            modifier = Modifier.fillMaxSize()
        )
    }
}