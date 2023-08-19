package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF3ddc84)
                ) {
                    BusinessCardApp(
                        getString(R.string.phone_number),
                        getString(R.string.email_id),
                        getString(R.string.social_media))
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(
    phoneNo: String,
    emailId: String,
    handle: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(105,239,136),

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageAdder()
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(30.dp)
        ) {
            BottomText(phoneNo, emailId, handle)
        }
    }


}


@Composable
fun BottomText(
    phoneNo: String,
    emailId: String,
    handle: String,
    modifier: Modifier = Modifier
) {
    val phoneIcon = painterResource(id = R.drawable.baseline_call_black_24dp)
    val mailIcon = painterResource(id = R.drawable.baseline_email_black_24dp)
    val handleIcon = painterResource(id = R.drawable.baseline_share_black_24dp)
    Column {
        Row {
            Icon(
                painter = phoneIcon,
                contentDescription = "Call",
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp),
                tint = Color(13,98,33)
            )
            Text(
                text = phoneNo,
                modifier = Modifier.padding(start = 16.dp),
                color = Color(13,98,33)
            )
        }
        Row(Modifier.padding(top = 5.dp)) {
            Icon(
                painter = handleIcon,
                contentDescription = "Social Media",
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp),
                tint = Color(13,98,33)
            )
            Text(
                text = handle,
                modifier = Modifier.padding(start = 16.dp),
                color = Color(13,98,33)
            )
        }
        Row(Modifier.padding(top = 5.dp)) {
            Icon(
                painter = mailIcon,
                contentDescription = "Contact",
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp),
                tint = Color(13,98,33)
            )
            Text(
                text = emailId,
                modifier = Modifier.padding(start = 16.dp),
                color = Color(13,98,33)
            )
        }
    }


}

@Composable
fun ImageAdder(modifier: Modifier = Modifier) {
    val imageAndroid = painterResource(id = R.drawable.android_logo_dark)
    Column {
        Image(
            painter = imageAndroid,
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Pratyush Prashob",
            textAlign = TextAlign.Center,
            //fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            //color = Color(4,70,20)
        )
        Text(
            text = "Trying to do better",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
            color = Color(13,98,33)
        )
    }
}


@Preview(showBackground = true,
showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp(
            "+91 9674363268",
            "pratyushprashob@gmail.com",
            "@pratyushprashob")
    }
}