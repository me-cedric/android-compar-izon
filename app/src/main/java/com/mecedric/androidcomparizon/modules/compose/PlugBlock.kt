package com.mecedric.androidcomparizon.modules.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecedric.androidcomparizon.R
import com.mecedric.androidcomparizon.modules.main.theme.AndroidAppTheme
import com.mecedric.androidcomparizon.modules.main.theme.MaterialThemeCustom

@Composable
fun PlugBlock(
    title: String? = null,
    text: String? = null,
    painter: Painter = painterResource(id = R.drawable.ic_favorite_placeholder),
    contentBoxScope: @Composable BoxScope.() -> Unit = {},
    contentColumnScope: @Composable ColumnScope.() -> Unit = {},
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Card(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .size(248.dp)
                        .align(Alignment.Center)
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        painter = painter,
                        contentDescription = null)
                }
            }

            title?.let {
                Spacer(modifier = Modifier.size(32.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = title.uppercase(),
                    style = MaterialTheme.typography.h5,
                )
            } ?: run {
                Spacer(modifier = Modifier.size(24.dp))
            }

            text?.let {
                Spacer(modifier = Modifier.size(16.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MaterialThemeCustom.colors.textColorSecondary,
                    text = text,
                    style = MaterialTheme.typography.subtitle1,
                )
            }

            contentColumnScope.invoke(this)
        }

        contentBoxScope.invoke(this)
    }
}

@Preview("Light")
@Preview("Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PlugBlockPreview() {
    AndroidAppTheme {
        Scaffold {
            PlugBlock(
                title = "Title",
                text = "Long text for preview",
            )
        }
    }
}