package com.example.pruebasqlite.Data

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class LogoApiService {

    val BASE_URL = "https://logo.clearbit.com/"// domain es donde tenemos que añadir la ruta
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val logoApiService = LogoApiService().getLogoApiService()


    // Agrega un método para obtener el servicio de Retrofit
    fun getLogoApiService(): LogoApiService {
        return retrofit.create(LogoApiService::class.java)
    }

    interface LogoApiService {
        @GET("logos")
        suspend fun getLogos(): String
    }

}

@Composable
fun LoadImageFromUrl(url: String) {
    val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(url) {
        val bitmap = loadImageFromUrl(url)
        imageBitmap.value = bitmap
    }

    imageBitmap.value?.let { bitmap ->
        Image(
            bitmap = bitmap,
            contentDescription = null, // Proporciona una descripción si es necesario
            contentScale = ContentScale.Fit // Ajusta la escala según tus necesidades
        )
    }
}

suspend fun loadImageFromUrl(url: String): ImageBitmap {
    var bitmap: ImageBitmap? = null
    withContext(Dispatchers.IO) {
        try {
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            bitmap = BitmapFactory.decodeStream(input)?.asImageBitmap()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    return bitmap ?: ImageBitmap(1, 1)
}