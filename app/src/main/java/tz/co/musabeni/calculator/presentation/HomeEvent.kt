package tz.co.musabeni.calculator.presentation

sealed interface HomeEvent{
    data class PressedButton(val number:Int):HomeEvent
    object ClearPassword:HomeEvent
    object RemoveLastCharacter:HomeEvent
    object ChangeTheme:HomeEvent
}