package tz.co.musabeni.calculator.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tz.co.musabeni.calculator.R
import tz.co.musabeni.calculator.presentation.HomeEvent
import tz.co.musabeni.calculator.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSection(
    modifier: Modifier,
    password:String,
    isPortrait:Boolean = true,
    onEvent: (HomeEvent) -> Unit = {}
){

   Surface(
       modifier = modifier,
       color = MaterialTheme.colorScheme.primary
   ) {
       Column(
           modifier = Modifier.fillMaxWidth(),
           horizontalAlignment = Alignment.End,
           verticalArrangement = Arrangement.SpaceBetween

       ) {
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(horizontal = MaterialTheme.dimens.small1),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.SpaceBetween
           ) {
             Image(
                 painter = painterResource(id = R.drawable.logos) ,
                 contentDescription = "Logo",
                 contentScale = ContentScale.Fit
             )
               Surface(
                   modifier = Modifier,
                   shape = MaterialTheme.shapes.small,
                   color = MaterialTheme.colorScheme.tertiaryContainer
               ) {
                   Text(
                       modifier = Modifier.padding(MaterialTheme.dimens.small1),
                       text = "99.999.99",
                       color = MaterialTheme.colorScheme.inverseOnSurface,
                       fontWeight = FontWeight.Bold
                   )
               }
           }
           Text(
               modifier = Modifier.fillMaxWidth(),
               text = stringResource(id = R.string.kat_pinin_girin),
               color = MaterialTheme.colorScheme.inverseOnSurface,
               textAlign = TextAlign.Center,
               style = MaterialTheme.typography.headlineSmall
           )

          Surface(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = MaterialTheme.dimens.small1),
              shape = RoundedCornerShape(MaterialTheme.dimens.small1),
              color = MaterialTheme.colorScheme.surfaceTint,
          ) {
              Box(
                  modifier = Modifier
                  .fillMaxWidth(),
                  contentAlignment = Alignment.Center
              ){
                  Text(
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(if (isPortrait) MaterialTheme.dimens.medium1 else MaterialTheme.dimens.small1),
                      text = "|",
                      style = MaterialTheme.typography.headlineLarge,
                      fontWeight = FontWeight.Bold,
                      color = Color.Transparent
                  )

                  Row(
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(if (isPortrait) MaterialTheme.dimens.medium1 else MaterialTheme.dimens.small1),
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically
                  ) {
                      repeat(4){index ->
                          if(password.length == index){
                              Text(
                                  text = "|",
                                  style = MaterialTheme.typography.headlineLarge,
                                  fontWeight = FontWeight.Bold,
                                  color = MaterialTheme.colorScheme.inverseOnSurface
                              )
                          }else{

                              if(index  >= password.length){

                                  ClearDot()
                              }else{
                                  PasswordDot()
                              }

                          }

                      }

                  }
              }

          }

           Image(
               modifier = Modifier
                   .padding(MaterialTheme.dimens.small2)
                   .clickable {
                       onEvent(HomeEvent.ChangeTheme)
                   },
               painter = painterResource(id = R.drawable.sun) ,
               contentDescription = "sun",
               contentScale = ContentScale.Fit
           )
       }


   }
}

@Composable
private fun PasswordDot() {
    Box(
        modifier = Modifier
            .size(MaterialTheme.dimens.small3)
            .background(
                color = MaterialTheme.colorScheme.inverseOnSurface,
                shape = CircleShape
            )

    )
}

@Composable
private fun ClearDot() {
    Box(
        modifier = Modifier
            .size(MaterialTheme.dimens.small3)
            .background(
                color = Color.Transparent,
                shape = CircleShape
            )

    )
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> "0"
        index > text.length -> ""
        else -> text[index].toString()
    }
    Text(
        modifier = Modifier
            .width(40.dp)
            .border(
                1.dp, when {
                    isFocused -> Color.DarkGray
                    else -> Color.Gray
                }, RoundedCornerShape(8.dp)
            )
            .padding(2.dp),
        text = char,
        style = MaterialTheme.typography.bodyLarge,
        color = if (isFocused) {
            Color.Gray
        } else {
            Color.DarkGray
        },
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTopSection(){
    TopSection(
        modifier = Modifier,
        password = ""
    )
}