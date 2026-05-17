# Nalla-Nudi

Nalla-Nudi is an Android application designed to help users learn technical terms in Kannada. It features a comprehensive dictionary of technical words, AI-powered translations, flashcards for learning, and text-to-speech support for both English and Kannada.

## Features

- **Technical Dictionary**: Explore technical terms across various subjects like Science, Mathematics, Commerce, and Computer Science.
- **AI Kannada Translator**: Get AI-generated explanations and translations for technical words using Google Gemini.
- **Flashcards**: Interactive flashcards to test your knowledge and help with memorization.
- **Text-to-Speech (TTS)**: Hear the pronunciation of both English and Kannada words.
- **Modern UI**: Built using Jetpack Compose for a smooth and modern user experience.

## Technology Stack

- **Kotlin**: Primary programming language.
- **Jetpack Compose**: For building modern UI components.
- **Room Database**: For local data storage.
- **Retrofit**: For network operations.
- **Google AI SDK (Gemini)**: For AI-powered translations.
- **TextToSpeech API**: For audio output.

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/likhitha286-ub/Nalla-Nudi.git
   ```

2. **API Key Setup**:
   - Obtain an API key from [Google AI Studio](https://aistudio.google.com/).
   - Add the following line to your `local.properties` file:
     ```properties
     GEMINI_API_KEY=YOUR_API_KEY_HERE
     ```

3. **Build and Run**:
   - Open the project in Android Studio.
   - Sync the project with Gradle files.
   - Run the application on an emulator or a physical device.

## Privacy and Security

The project is configured to keep API keys secure. The API key is stored in `local.properties`, which is excluded from version control via `.gitignore`. The key is provided to the app via `BuildConfig`.
