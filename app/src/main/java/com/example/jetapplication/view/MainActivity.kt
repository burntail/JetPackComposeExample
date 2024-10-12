package com.example.jetapplication.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.jetapplication.ui.theme.JetApplicationTheme
import com.example.jetapplication.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContent {
            JetApplicationTheme {
                TotalLayout()
            }
        }
    }

    @Composable
    fun TotalLayout() {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (text, button1, button2) = createRefs()

            Text (
                text = "클릭한 버튼 횟수: ${mainActivityViewModel.retNumOfClickButton.value}",
                modifier = Modifier.constrainAs(text) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )

            Button(
                onClick = {
                    mainActivityViewModel.incrementCount()
                },
                modifier = Modifier.constrainAs(button1) {
                    top.linkTo(text.bottom, margin = 20.dp)
                    start.linkTo(text.start)
                    end.linkTo(text.end)
                }
            ) {
                Text(text = "Click this increase button")
            }

            Button(
                onClick = {
                    mainActivityViewModel.resetCount()
                },
                modifier = Modifier.constrainAs(button2) {
                    top.linkTo(button1.bottom, margin = 20.dp)
                    start.linkTo(button1.start)
                    end.linkTo(button1.end)
                },
                colors =  ButtonDefaults.buttonColors(
                    Color.Red
                ),
                
            ) {
                Text(text = "Click this reset button")
            }


        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        JetApplicationTheme {
            TotalLayout()
        }
    }
}

