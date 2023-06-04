package com.example.musicplayercompose.view
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicplayercompose.R
import com.example.musicplayercompose.ui.theme.darkBlue
import com.example.musicplayercompose.ui.theme.lightBlue
import com.example.musicplayercompose.ui.theme.sliderActiveColor

@Composable
fun mainView(){
    Scaffold() {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = lightBlue)) {

           Column(modifier = Modifier.padding(16.dp)) {
               // header text
               Spacer(modifier = Modifier.height(8.dp))
               Text(text = "Music Player App Demo", fontSize = 24.sp, fontWeight = FontWeight.Black, color = Color.White)
               Text(text = "developer : mohammad dehghanifard", fontSize = 14.sp, fontWeight = FontWeight.Normal,color = Color.White)
               Spacer(modifier = Modifier.height(32.dp))

               // poster
               Card(modifier = Modifier
                   .fillMaxWidth()
                   .height(360.dp)
                   .align(alignment = Alignment.CenterHorizontally),
                   shape = RoundedCornerShape(16.dp),
               ) {
                   Image(painterResource(id = R.drawable.poster), contentDescription = null, contentScale = ContentScale.Crop )

               }
                // information
               Spacer(modifier = Modifier.height(12.dp))
               Text(text = "Tobe Kardam", fontSize = 24.sp, fontWeight = FontWeight.Black, color = Color.White, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
               Text(text = "kasra zahedi", fontSize = 14.sp, fontWeight = FontWeight.Normal,color = Color.White,modifier = Modifier.align(alignment = Alignment.CenterHorizontally))


           }

            // controller
           Card(modifier = Modifier
               .align(alignment = Alignment.BottomCenter)
               .fillMaxWidth()
               .height(250.dp),
               shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
               backgroundColor = Color.White
           ) {
            Column(modifier = Modifier.padding(12.dp)) {
                //slider
                Slider(
                    colors = SliderDefaults.colors(
                        thumbColor = darkBlue,
                        activeTrackColor = sliderActiveColor
                    ),
                    value = 0.5f,
                    onValueChange = {}
                )

                Spacer(modifier = Modifier.height(32.dp))
                
                Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(68.dp))

                    //play icon
                    Card(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(64),
                        backgroundColor = darkBlue
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.PlayArrow, contentDescription = null, tint = Color.White)
                        }
                    }

                    Spacer(modifier = Modifier.width(68.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                    }

                }
            }
           }
        }
    }
}

