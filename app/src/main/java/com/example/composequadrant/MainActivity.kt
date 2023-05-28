package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuadrantGrid()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantGrid(){
Column() {
   Row() {
       QuadrantGridChild(title = stringResource(id = R.string.TextComposable), subtitle = stringResource(
           id = R.string.DisplaysText,
       ) ,
           color = Color(0xFFEADDFF)
       )
       QuadrantGridChild(title = stringResource(id = R.string.ImageComposable), subtitle = stringResource(
           id = R.string.CreatesAComposablePainter,
       ) ,
           color = Color(0xFFD0BCFF)
       )
   }
    Row() {
        QuadrantGridChild(title = stringResource(id = R.string.RowComposable), subtitle = stringResource(
            id = R.string.HorizontalLayoutComposable,
        ) ,
            color = Color(0xFFB69DF8)
        )
        QuadrantGridChild(title = stringResource(id = R.string.ColumnComposable), subtitle = stringResource(
            id = R.string.VerticalLayoutComposable,
        ) ,
            color = Color(0xFFF6EDFF)
        )
    }
}

}

@Composable
fun QuadrantGridChild(title : String, subtitle: String,color: Color,modifier: Modifier = Modifier){

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    Box(
        modifier = modifier
            .background(color = color)
            .height(height = (screenHeight / 2))
            .width(width = (screenWidth / 2))
    ){
     Column(
         modifier = modifier.padding(16.dp).align(alignment = Alignment.Center),
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         TileTitle(title = title)
         TileSubText(subtitle = subtitle)
     }
    }
}

@Composable
fun TileTitle(title:String,modifier: Modifier = Modifier){
    Text(text = title , fontWeight = FontWeight.Bold,modifier = modifier.padding(bottom = 16.dp))
}

@Composable
fun TileSubText(subtitle: String){
    Text(text = subtitle, textAlign = TextAlign.Justify,  fontSize = 16.sp)
}