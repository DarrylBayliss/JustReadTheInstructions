package com.example.justreadtheinstructions.presentation.main

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.justreadtheinstructions.R
import com.example.justreadtheinstructions.domain.Launch
import com.example.justreadtheinstructions.domain.SampleLaunchProvider
import com.example.justreadtheinstructions.presentation.detail.LaunchesDetailActivity
import com.example.justreadtheinstructions.presentation.theme.JustReadTheInstructionsTheme
import com.skydoves.landscapist.coil.CoilImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustReadTheInstructionsTheme {
                LaunchList()
            }
        }
    }
}

@Composable
fun LaunchList(viewModel: MainViewModel = viewModel()) {

    val launches by viewModel.launches.observeAsState()

    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(launches!!) { launch ->
            LaunchCard(launch = launch)
        }
    }

    viewModel.getLaunches()
}

@Composable
@Preview(showBackground = true)
fun LaunchCard(@PreviewParameter(SampleLaunchProvider::class) launch: Launch) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable {
                val intent = Intent(context, LaunchesDetailActivity::class.java)
                intent.putExtra(LaunchesDetailActivity.LAUNCH_EXTRA, launch)
                context.startActivity(intent)
            },
        elevation = 8.dp
    ) {
        Row {
            if (launch.image != null) {
                CoilImage(
                    imageModel = launch.image,
                    modifier = Modifier
                        .size(100.dp)
                        .then(Modifier.padding(8.dp)),
                    contentScale = ContentScale.Fit,
                    placeHolder = ImageBitmap.imageResource(id = R.drawable.space_x_logo)
                )
            }
            Column(Modifier.padding(8.dp)) {
                Text(text = launch.name)
                Text(launch.date)
            }
        }
    }
}