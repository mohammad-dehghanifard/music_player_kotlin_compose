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
import com.example.musicplayercompose.ui.theme.lightBlue

@Composable
fun mainView(){
    Scaffold() {
        Box(modifier = Modifier.fillMaxSize().background(color = lightBlue)) {
            // cover
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .align(alignment = Alignment.Center)
                    .padding(horizontal = 6.dp),
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(15)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    // poster image
                    Card(
                        modifier = Modifier
                            .width(160.dp)
                            .height(160.dp),
                        shape = RoundedCornerShape(12),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.poster),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    // information
                    Text(text = "Tobe Kardam", fontSize = 24.sp, fontWeight = FontWeight.Black)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Kasra Zahedi", fontSize = 12.sp, fontWeight = FontWeight.Normal)

                    Spacer(modifier = Modifier.height(32.dp))

                    //controller
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = null)
                        }

                        Card(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp),
                            shape = RoundedCornerShape(64),
                            backgroundColor = Color.Red
                        ) {
                            IconButton(
                                onClick = { /*TODO*/ }) {
                                Icon(
                                    Icons.Filled.PlayArrow,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }

                        IconButton(
                            onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    //slider
                    Slider(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        value = 0f,
                        onValueChange = {},
                        colors = SliderDefaults.colors(
                            activeTickColor = Color.Red,
                            disabledActiveTickColor = Color.Gray
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        Text(text = "00 : 00", fontSize = 12.sp, fontWeight = FontWeight.Normal)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "02:56", fontSize = 12.sp, fontWeight = FontWeight.Normal)
                    }
                }

            }
        }
    }
}

