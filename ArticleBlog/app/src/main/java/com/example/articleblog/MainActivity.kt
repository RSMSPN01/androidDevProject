package com.example.articleblog

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.articleblog.ui.theme.ArticleBlogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleBlogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayBlog(
                        // extract the string resources to make it look clean
                        stringResource(R.string.heading),
                        stringResource(R.string.paragraph1),
                        stringResource(R.string.paragraph2),
                        modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}
// step 3: Display all the text paragraphs
@Composable
fun DisplayBlog (heading : String,para1 : String, para2 : String, modifier: Modifier) {
    // these four image and texts should display in columns
    Column(modifier = Modifier) {
        // call the image fun here itself
        DisplayMainImage(modifier = Modifier)
        Text(
            text = heading,
            fontSize = 24.sp,
            lineHeight = 20.sp,
            modifier= Modifier.padding(16.dp)
            )
        Text(
            text = para1,
            textAlign = TextAlign.Justify,
            modifier= Modifier.padding(16.dp)
        )
        Text(
            text = para2,
            textAlign = TextAlign.Justify,
            modifier= Modifier.padding(16.dp)
        )
    }
}
// step 2: create the image displaying function
// import the image first - from resource manager
@Composable
fun DisplayMainImage (modifier: Modifier) {
    val image = painterResource(R.drawable.bg_compose_background);
    Image (
//    val image = painterResource(R.drawable.bg_compose_background);
        painter = image,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}
// step 1: create a preview fun first
@Preview(showBackground = true)
@Composable
fun BlogPreview () {
// in preview function we don't pass any parameter
//    DisplayMainImage(modifier = Modifier)
    // call the function
    DisplayBlog(stringResource(R.string.heading),
        stringResource(R.string.paragraph1),
        stringResource(R.string.paragraph2),
        modifier = Modifier
    )
}

