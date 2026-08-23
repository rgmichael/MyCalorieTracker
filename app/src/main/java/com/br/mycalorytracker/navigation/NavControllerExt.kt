package com.br.mycalorytracker.navigation

import androidx.navigation.NavController
import com.br.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}