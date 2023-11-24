package tz.co.musabeni.calculator.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tz.co.musabeni.calculator.R
import tz.co.musabeni.calculator.presentation.HomeEvent
import tz.co.musabeni.calculator.ui.theme.dimens


@Composable
fun ButtonSection(
    modifier: Modifier = Modifier,
    onEvent: (HomeEvent) -> Unit
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small2)
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
        ) {
         Row(
             modifier = Modifier.weight(1f),
             horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
         ) {
             CustomButton(
                 modifier = Modifier
                     .weight(1f)
                     .fillMaxHeight()
                 ,
                 value = 1,
                 onClick = {
                     onEvent(HomeEvent.PressedButton(1))
                 }
             )
             CustomButton(
                 modifier = Modifier
                     .weight(1f)
                     .fillMaxHeight()
                 ,
                 value = 2,
                 onClick = {
                     onEvent(HomeEvent.PressedButton(2))
                 }

             )
             CustomButton(
                 modifier = Modifier
                     .weight(1f)
                     .fillMaxHeight()
                 ,
                 value = 3,
                 onClick = {
                     onEvent(HomeEvent.PressedButton(3))
                 }
             )
         }
         Row(
             modifier = Modifier.weight(1f),
             horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
         ) {
                CustomButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    value = 4,
                    onClick = {
                        onEvent(HomeEvent.PressedButton(4))
                    }
                )
                CustomButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    value = 5,
                    onClick = {
                        onEvent(HomeEvent.PressedButton(5))
                    }
                )
                CustomButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    value = 6,
                    onClick = {
                        onEvent(HomeEvent.PressedButton(6))
                    }
                )
            }

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
            ) {
                CustomButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    value = 7,
                    onClick = {
                        onEvent(HomeEvent.PressedButton(7))
                    }
                )
                CustomButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    value = 8,
                    onClick = {
                        onEvent(HomeEvent.PressedButton(8))
                    }
                )
                CustomButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    value = 9,
                    onClick = {
                        onEvent(HomeEvent.PressedButton(9))
                    }
                )
            }
         Row(
             modifier = Modifier.weight(1f),
             horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small1)
         ) {
             IconBtn(modifier = Modifier
                 .weight(1f)
                 .fillMaxHeight()
                 .clickable {
                     onEvent(HomeEvent.ClearPassword)
                 },
                 icon = R.drawable.clear)

                CustomButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    value = 0,
                    onClick = {
                        onEvent(HomeEvent.PressedButton(0))
                    }
                )

             IconBtn(modifier = Modifier
                 .weight(1f)
                 .fillMaxHeight()
                 .clickable {
                     onEvent(HomeEvent.RemoveLastCharacter)
                 },
                 icon = R.drawable.back_arrow)


            }
        }


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            shape = RoundedCornerShape(MaterialTheme.dimens.small1),
            border = BorderStroke(
                color = MaterialTheme.colorScheme.tertiary,
                width = 1.dp
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(MaterialTheme.dimens.iconBtnSize)
                        .padding(MaterialTheme.dimens.small1),
                    painter =  painterResource(id = R.drawable.ellipse),
                    contentDescription =null,
                    contentScale = ContentScale.Fit,

                )
                Text(
                    text = stringResource(id = R.string.onayla),
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }

}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    value:Int,
    onClick: () -> Unit
){

    Button(
        modifier = modifier,
        shape = RoundedCornerShape(MaterialTheme.dimens.small1),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = MaterialTheme.dimens.small1
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                modifier = Modifier
                    .wrapContentSize(),
                text = "$value",
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }





}

@Composable
fun IconBtn(
    modifier: Modifier,
    @DrawableRes icon:Int
){
    Box(
        modifier =modifier,
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier = Modifier.wrapContentSize(),
            painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}



@Preview(showBackground = false)
@Composable
fun PreviewCustomButton(){
    ButtonSection(
        onEvent = {}
    )
}