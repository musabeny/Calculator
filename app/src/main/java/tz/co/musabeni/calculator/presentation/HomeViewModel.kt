package tz.co.musabeni.calculator.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor():ViewModel() {

    private  val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.PressedButton ->{
                if(_state.value.password.length > 4){
                    return
                }
                _state.update {
                    it.copy(password = "${_state.value.password}${event.number}")
                }
            }
            is HomeEvent.ClearPassword ->{
                _state.update {
                    it.copy(password = "")
                }
            }
            is HomeEvent.RemoveLastCharacter ->{
              _state.update {
                  it.copy(password = _state.value.password.dropLast(1))
              }
            }
            is HomeEvent.ChangeTheme ->{
                _state.update {
                    it.copy(isDarkMode = !_state.value.isDarkMode)
                }
            }
        }
    }
}