package com.example.nallnudi.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import com.example.nallnudi.data.model.TermEntity
import com.example.nallnudi.utils.TtsHelper

@Composable
fun HomeScreen() {

    val context = LocalContext.current
    val ttsHelper = remember { TtsHelper(context) }

    DisposableEffect(Unit) {
        onDispose {
            ttsHelper.shutdown()
        }
    }

    val subjects = listOf(
        "Science",
        "Mathematics",
        "Commerce",
        "Computer Science",
        "Chemistry",
        "Biology"
    )

    var selectedSubject by remember {
        mutableStateOf("Science")
    }

    var searchText by remember {
        mutableStateOf("")
    }

    val sampleWords = listOf(

        // SCIENCE

        TermEntity(
            englishWord = "Gravity",
            kannadaMeaning = "ಗುರುತ್ವಾಕರ್ಷಣೆ",
            example = "Gravity pulls objects toward Earth.",
            subject = "Science"
        ),

        TermEntity(
            englishWord = "Photosynthesis",
            kannadaMeaning = "ಕಾಂತಿಯ ಸಂಶ್ಲೇಷಣೆ",
            example = "Plants prepare food using sunlight.",
            subject = "Science"
        ),

        TermEntity(
            englishWord = "Atom",
            kannadaMeaning = "ಅಣು",
            example = "Atom is the smallest particle.",
            subject = "Science"
        ),

        TermEntity(
            englishWord = "Energy",
            kannadaMeaning = "ಶಕ್ತಿ",
            example = "Energy is needed to do work.",
            subject = "Science"
        ),

        // MATHEMATICS

        TermEntity(
            englishWord = "Algebra",
            kannadaMeaning = "ಬೀಜಗಣಿತ",
            example = "Algebra uses symbols and equations.",
            subject = "Mathematics"
        ),

        TermEntity(
            englishWord = "Trigonometry",
            kannadaMeaning = "ತ್ರಿಕೋನಮಿತಿ",
            example = "Trigonometry studies triangles.",
            subject = "Mathematics"
        ),

        TermEntity(
            englishWord = "Geometry",
            kannadaMeaning = "ಜ್ಯಾಮಿತಿ",
            example = "Geometry studies shapes.",
            subject = "Mathematics"
        ),

        // COMMERCE

        TermEntity(
            englishWord = "Economics",
            kannadaMeaning = "ಅರ್ಥಶಾಸ್ತ್ರ",
            example = "Economics studies money and trade.",
            subject = "Commerce"
        ),

        TermEntity(
            englishWord = "Revenue",
            kannadaMeaning = "ಆದಾಯ",
            example = "Revenue is total business income.",
            subject = "Commerce"
        ),

        // COMPUTER SCIENCE

        TermEntity(
            englishWord = "Algorithm",
            kannadaMeaning = "ಅಲ್ಗೋರಿದಮ್",
            example = "Algorithm solves problems step-by-step.",
            subject = "Computer Science"
        ),

        TermEntity(
            englishWord = "Database",
            kannadaMeaning = "ದತ್ತಸಂಗ್ರಹ",
            example = "Database stores information.",
            subject = "Computer Science"
        ),

        // CHEMISTRY

        TermEntity(
            englishWord = "Molecule",
            kannadaMeaning = "ಅಣುಗುಚ್ಛ",
            example = "Molecule contains atoms.",
            subject = "Chemistry"
        ),

        TermEntity(
            englishWord = "Acid",
            kannadaMeaning = "ಆಮ್ಲ",
            example = "Acid reacts with bases.",
            subject = "Chemistry"
        ),

        // BIOLOGY

        TermEntity(
            englishWord = "Cell",
            kannadaMeaning = "ಕೋಶ",
            example = "Cell is the basic unit of life.",
            subject = "Biology"
        ),

        TermEntity(
            englishWord = "Respiration",
            kannadaMeaning = "ಉಸಿರಾಟ",
            example = "Respiration releases energy.",
            subject = "Biology"
        )
    )

    val filteredWords = sampleWords.filter {

        it.subject == selectedSubject &&
                it.englishWord.contains(
                    searchText,
                    ignoreCase = true
                )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Text(
            text = "Nalla-Nudi",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Search Technical Word")
            },
            leadingIcon = {
                Icon(Icons.Default.Search, null)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Subjects",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow {

            items(subjects) { subject ->

                FilterChip(

                    selected = selectedSubject == subject,

                    onClick = {
                        selectedSubject = subject
                    },

                    label = {
                        Text(subject)
                    },

                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(filteredWords) { word ->

                WordCard(word, ttsHelper)
            }
        }
    }
}

@Composable
fun WordCard(word: TermEntity, ttsHelper: TtsHelper) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = word.englishWord,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                IconButton(
                    onClick = {
                        val textToSpeak = "${word.englishWord}. ${word.kannadaMeaning}"
                        ttsHelper.speak(textToSpeak, "kn")
                    }
                ) {

                    Icon(
                        Icons.Default.VolumeUp,
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = word.kannadaMeaning,
                color = Color.Blue,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = word.example
            )
        }
    }
}
