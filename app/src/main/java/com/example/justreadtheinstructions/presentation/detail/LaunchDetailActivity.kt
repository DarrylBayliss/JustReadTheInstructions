package com.example.justreadtheinstructions.presentation.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.justreadtheinstructions.R
import com.example.justreadtheinstructions.domain.Launch
import com.example.justreadtheinstructions.presentation.theme.JustReadTheInstructionsTheme
import com.skydoves.landscapist.coil.CoilImage

class LaunchesDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val launch: Launch = intent.getParcelableExtra(LAUNCH_EXTRA)!!

        setContent {
            JustReadTheInstructionsTheme {
                LaunchDetail(launch = launch)
            }
        }
    }

    companion object {
        const val LAUNCH_EXTRA = "launch"
    }
}

@Composable
fun LaunchDetail(launch: Launch) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 8.dp
    ) {

        Column(Modifier.padding(8.dp)) {

            if (launch.image != null) {
                CoilImage(
                    imageModel = launch.image,
                    modifier = Modifier
                        .then(Modifier.padding(8.dp)),
                    contentScale = ContentScale.Fit,
                    placeHolder = ImageBitmap.imageResource(id = R.drawable.space_x_logo)
                )
            }

            Row(Modifier.padding(top = 4.dp)) {
                Text(text = "Name:", fontWeight = FontWeight.Bold)
                Text(text = launch.name, Modifier.padding(start = 4.dp))
            }

            Row(Modifier.padding(top = 4.dp)) {
                Text(text = "Launch Date:", fontWeight = FontWeight.Bold)
                Text(text = launch.date, Modifier.padding(start = 4.dp))
            }

            Row(Modifier.padding(top = 4.dp)) {
                Text(text = "Details:", fontWeight = FontWeight.Bold)
                Text(text = launch.details ?: "Not available", Modifier.padding(start = 4.dp))
            }

            Row(Modifier.padding(top = 4.dp)) {
                Text(
                    text = "Webcast:",
                    fontWeight = FontWeight.Bold
                )
                Text(text = launch.webcast.toString(),
                    Modifier
                        .clickable {
                            val openUrlIntent = Intent(Intent.ACTION_VIEW, launch.webcast)
                            context.startActivity(openUrlIntent)

                        }
                        .padding(start = 4.dp),
                    color = Blue
                )
            }
        }
    }
}