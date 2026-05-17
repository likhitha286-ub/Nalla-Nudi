package com.example.nallnudi.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

class TtsHelper(context: Context) {
    private var tts: TextToSpeech? = null
    private var isInitialized = false
    private var pendingText: Pair<String, String>? = null

    init {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                isInitialized = true
                Log.d("TtsHelper", "TTS Initialized successfully")
                
                // Speak any pending text that was requested during initialization
                pendingText?.let { (text, lang) ->
                    speak(text, lang)
                    pendingText = null
                }
            } else {
                Log.e("TtsHelper", "TTS Initialization failed with status: $status")
            }
        }
    }

    fun speak(text: String, language: String = "en") {
        if (!isInitialized) {
            Log.w("TtsHelper", "Speak called before initialization, queuing text")
            pendingText = Pair(text, language)
            return
        }

        val locale = if (language == "kn") {
            Locale("kn", "IN")
        } else {
            Locale.US
        }

        val result = tts?.setLanguage(locale)
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Log.e("TtsHelper", "Language $language is not supported or missing data")
        }

        Log.d("TtsHelper", "Speaking: $text in $language")
        // Use QUEUE_FLUSH to interrupt any current speech and play the new one immediately
        // Use a non-null utteranceId to ensure it works on all versions
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "UtteranceID_${System.currentTimeMillis()}")
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}
