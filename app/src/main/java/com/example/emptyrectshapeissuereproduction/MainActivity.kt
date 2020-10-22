package com.example.emptyrectshapeissuereproduction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.Density
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

import com.example.emptyrectshapeissuereproduction.ui.EmptyRectShapeIssueReproductionTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptyRectShapeIssueReproductionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Screen(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    var sliderValue by remember { mutableStateOf(1f) }
    Column(modifier) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .clip(PercentageRectangleShape(sliderValue))
                .background(Color.Gray)
        )
        Slider(
            value = sliderValue,
            onValueChange = {
                sliderValue = it
            }
        )
    }
}

@Stable
class PercentageRectangleShape(private val percentage: Float): Shape {
    override fun createOutline(size: Size, density: Density): Outline =
        Outline.Rectangle(Rect(Offset.Zero, size * percentage))
}
