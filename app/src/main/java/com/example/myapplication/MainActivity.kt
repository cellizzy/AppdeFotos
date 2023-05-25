package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppDefotos()


                }
            }
        }
    }
}
@Preview
@Composable
fun AppDefotos() {
    var idFotos by remember { mutableStateOf(1) }
    var tela by remember { mutableStateOf(1) }
    var Idtitulo by remember { mutableStateOf(1) }
    var Iddescricao by remember { mutableStateOf(1) }


    when (tela){
        1-> {
            idFotos =R.drawable.harty
            Idtitulo= R.string.tituloImagem1
            Iddescricao= R.string.descricaoImagem1
        }
        2->{
            idFotos = R.drawable.harrypottereacamarasecretaposter
            Idtitulo=R.string.tituloImagem2
            Iddescricao=R.string.descricaoImagem2
        }
        3->{
            idFotos = R.drawable.harrypottereoprisioneirodeazkaban
            Idtitulo = R.string.tituloImagem3
            Iddescricao = R.string.descricaoImagem3
        }

        4->{
            idFotos=R.drawable.harrypotter
            Idtitulo=R.string.tituloImagem4
            Iddescricao=R.string.descricaoImagem4
        }


        5->{
            idFotos=R.drawable.harrypottereaordemdafenix
            Idtitulo=R.string.tituloImagem5
            Iddescricao=R.string.descricaoImagem5
        }
    }



    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ) {
//__________________________________Moldura da Imagem_____________________
            Surface(
                shadowElevation = 4.dp,

            ){
                Image(
                    painter = painterResource(id = idFotos),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.padding(20.dp)
                )
            }
 //--------------------Descricao imagem----------------
            Card(
                colors = CardDefaults.cardColors(Color.White),
                elevation =CardDefaults.cardElevation(4.dp),
                border = BorderStroke(1.dp, Color.DarkGray)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(15.dp)
                ) {

                    Text(
                        text = stringResource(id = Idtitulo),

                    )
                    Text(
                        text = stringResource(id = Iddescricao)
                    )
                }
            }
//------------------------------------------Botoes de Navegação-------------------------
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BotaoNavegacao(text ="Voltar") {
                    if (tela>1)
                        tela--
                }
                BotaoNavegacao(text ="Proximo") {
                    if (tela<5)
                        tela++

                }
            }
        }
    }
}
@Composable
fun BotaoNavegacao(
    text:String,
    onClick:()->Unit

){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Text(
            text = text
        )
    }
}





