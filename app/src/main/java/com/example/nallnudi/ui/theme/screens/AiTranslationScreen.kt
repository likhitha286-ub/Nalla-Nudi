package com.example.nallnudi.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nallnudi.utils.GeminiHelper
import com.example.nallnudi.utils.TtsHelper
import kotlinx.coroutines.launch

@Composable
fun AiTranslationScreen() {

    val context = LocalContext.current
    val ttsHelper = remember { TtsHelper(context) }

    DisposableEffect(Unit) {
        onDispose {
            ttsHelper.shutdown()
        }
    }

    var inputText by remember {
        mutableStateOf("")
    }

    var outputText by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Text(
            text = "AI Kannada Translator",
            fontSize = 28.sp,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = inputText,
            onValueChange = {
                inputText = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Enter Technical Word")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                scope.launch {

                    try {

                        val response =
                            GeminiHelper.generativeModel
                                .generateContent(

                                    "Explain and translate this technical word into Kannada: $inputText"
                                )

                        outputText =
                            response.text ?: "No response"

                    } catch (e: Exception) {

                        outputText =
                            e.message ?: "Error"
                    }
                }
            }
        ) {

            Text("Generate AI Meaning")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (outputText.isNotEmpty()) {
                    ttsHelper.speak(outputText, "kn")
                }
            }
        ) {

            Text(
                text = outputText,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}