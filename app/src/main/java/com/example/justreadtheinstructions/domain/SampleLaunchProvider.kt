package com.example.justreadtheinstructions.domain

import android.net.Uri
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import java.net.URL

class SampleLaunchProvider : PreviewParameterProvider<Launch> {

    override val values: Sequence<Launch> = sequenceOf(
        Launch(
            "Launch 1",
            "11-05-2018",
            "Some details",
            Uri.parse("https://www.hdnicewallpapers.com/Walls/Big/Rainbow/Rainbow_on_Mountain_HD_Image.jpg"),
            Uri.parse("https://www.hdnicewallpapers.com/Walls/Big/Rainbow/Rainbow_on_Mountain_HD_Image.jpg")
        ),
        Launch(
            "Launch 2",
            "11-05-2019",
            "Some details",
            Uri.parse("https://www.hdnicewallpapers.com/Walls/Big/Rainbow/Rainbow_on_Mountain_HD_Image.jpg"),
            Uri.parse("https://www.hdnicewallpapers.com/Walls/Big/Rainbow/Rainbow_on_Mountain_HD_Image.jpg")
        )
    )

    override val count: Int = values.count()
}