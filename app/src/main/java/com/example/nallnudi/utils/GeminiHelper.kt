package com.example.nallnudi.utils

import com.example.nallnudi.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel

object GeminiHelper {

    val generativeModel =
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = BuildConfig.GEMINI_API_KEY
        )
}
