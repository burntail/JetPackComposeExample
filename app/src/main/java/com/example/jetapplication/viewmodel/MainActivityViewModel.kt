package com.example.jetapplication.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {
    private val numOfClickButton = mutableIntStateOf(0)
    val retNumOfClickButton : State<Int> = numOfClickButton


    fun incrementCount() {
        numOfClickButton.intValue += 1
    }

    fun resetCount() {
        numOfClickButton.intValue = 0
    }
}