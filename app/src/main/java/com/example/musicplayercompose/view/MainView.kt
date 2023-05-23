package com.example.musicplayercompose.view
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.renderscript.Allocation
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicplayercompose.R

@Composable
fun mainView(){
    Scaffold() {
        Box(modifier = Modifier.fillMaxSize()) {
            //back bg
            val bitmap = BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.poster)
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                LegacyBlurImage(bitmap, 25f)
            } else {
                BlurImage(
                    bitmap,
                    Modifier
                        .fillMaxSize()
                        .blur(radiusX = 25.dp, radiusY = 25.dp)
                )
            }
            // cover
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(650.dp)
                    .align(alignment = Alignment.Center),
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(15)
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    
                }
            }
        }
    }
}

@Composable
private fun LegacyBlurImage(
    bitmap: Bitmap,
    blurRadio: Float,
    modifier: Modifier = Modifier.fillMaxSize()
) {

    val renderScript = RenderScript.create(LocalContext.current)
    val bitmapAlloc = Allocation.createFromBitmap(renderScript, bitmap)
    ScriptIntrinsicBlur.create(renderScript, bitmapAlloc.element).apply {
        setRadius(blurRadio)
        setInput(bitmapAlloc)
        forEach(bitmapAlloc)
    }
    bitmapAlloc.copyTo(bitmap)
    renderScript.destroy()
    BlurImage(bitmap, modifier)
}

@Composable
fun BlurImage(
    bitmap: Bitmap,
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}