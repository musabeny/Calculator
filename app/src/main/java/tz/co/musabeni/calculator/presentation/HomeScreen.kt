package tz.co.musabeni.calculator.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import tz.co.musabeni.calculator.presentation.component.ButtonSection
import tz.co.musabeni.calculator.presentation.component.LandscapeScreen
import tz.co.musabeni.calculator.presentation.component.PortraitScreen
import tz.co.musabeni.calculator.presentation.component.TopSection
import tz.co.musabeni.calculator.ui.theme.CalculatorTheme
import tz.co.musabeni.calculator.ui.theme.ScreenOrientation
import tz.co.musabeni.calculator.ui.theme.dimens

@AndroidEntryPoint
class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<HomeViewModel>()
            val state = viewModel.state.collectAsState()
            val onEvent = viewModel::onEvent
            CalculatorTheme(
                darkTheme = state.value.isDarkMode
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if(ScreenOrientation == Configuration.ORIENTATION_PORTRAIT){
                        PortraitScreen(
                            modifier =  Modifier
                                .fillMaxSize(),
                            state = state.value,
                            onEvent = onEvent
                        )
                    }else{
                        LandscapeScreen(
                            modifier =  Modifier
                                .fillMaxSize(),
                            state = state.value,
                            onEvent = onEvent
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Greeting("Android")
    }
}