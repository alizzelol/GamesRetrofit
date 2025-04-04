package com.alizzelol.gamesretrofit.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.alizzelol.gamesretrofit.model.GameList
import com.alizzelol.gamesretrofit.util.Constants.Companion.CUSTOM_BLACK
import androidx.core.net.toUri
import com.alizzelol.gamesretrofit.util.Constants.Companion.CUSTOM_GREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable //TopBar genérico
//Unit significa void en Java, que no devuelve ningún valor significativo
fun MainTopBar(title:String, showBackButton:Boolean = false, onClickBackButton: () -> Unit){
    TopAppBar(
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(CUSTOM_BLACK) //Usar valor para colores
        ),
        navigationIcon = {
            if(showBackButton){ //Botón de ir hacia atrás
                IconButton(onClick = onClickBackButton){
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }
    )
}

@Composable
fun CardGame(game: GameList, onClick:() -> Unit){ //click para ir a la siguiente vista
    Card (
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onClick() }
    ) {
        Column {
            MainImage(image = game.background_image)
        }
    }
}

@Composable
fun MainImage(image:String){ //Poner la imagen del juego
    val image = rememberImagePainter(data = image)
    Image(painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        //Para determinar el contenido, Crop hace que se vea a niveles normales
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}

@Composable
fun MetaWebsite(url : String){

    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())

    Column {
        Text(text = "METASCORE",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        Button(onClick = {context.startActivity(intent)}, colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.Gray
        )) {
            Text(text = "Sitio Web")
        }

    }
}

@Composable
fun RewiewCard(metascore : Int){ //Donde mostrar puntuación del juego
    Card(
        modifier = Modifier
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(CUSTOM_GREEN)
        )
    ){
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = metascore.toString(),
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 50.sp
            )

        }
    }
}


















