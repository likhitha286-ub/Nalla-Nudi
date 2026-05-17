package com.example.nallnudi.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.nallnudi.utils.TtsHelper

data class Flashcard(

    val english: String,

    val kannada: String
)

@Composable
fun FlashcardScreen() {

    val context = LocalContext.current
    val ttsHelper = remember { TtsHelper(context) }

    DisposableEffect(Unit) {
        onDispose {
            ttsHelper.shutdown()
        }
    }

    val flashcards = listOf(

        Flashcard(
            "Gravity",
            "ಗುರುತ್ವಾಕರ್ಷಣೆ"
        ),

        Flashcard(
            "Atom",
            "ಅಣು"
        ),

        Flashcard(
            "Algorithm",
            "ಅಲ್ಗೋರಿದಮ್"
        ),

        Flashcard(
            "Economics",
            "ಅರ್ಥಶಾಸ್ತ್ರ"
        ),

        Flashcard(
            "Photosynthesis",
            "ಕಾಂತಿಯ ಸಂಶ್ಲೇಷಣೆ"
        )
    )

    var currentIndex by remember {
        mutableStateOf(0)
    }

    var showMeaning by remember {
        mutableStateOf(false)
    }

    val currentCard =
        flashcards[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Center
    ) {

        Text(
            text = "Flashcards",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),

            shape = RoundedCornerShape(20.dp),

            elevation =
                CardDefaults.cardElevation(10.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFE3F2FD))
                    .padding(20.dp),

                horizontalAlignment =
                    Alignment.CenterHorizontally,

                verticalArrangement =
                    Arrangement.Center
            ) {

                if (showMeaning) {

                    Text(
                        text = currentCard.kannada,
                        fontSize = 34.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )

                } else {

                    Text(
                        text = currentCard.english,
                        fontSize = 34.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                showMeaning = !showMeaning
                if (showMeaning) {
                    ttsHelper.speak(currentCard.kannada, "kn")
                } else {
                    ttsHelper.speak(currentCard.english, "en")
                }
            }
        ) {

            Text("Flip Card")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

                currentIndex = (currentIndex + 1) % flashcards.size

                showMeaning = false
            }
        ) {

            Text("Next Card")
        }
    }
}
