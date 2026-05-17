# 📖 Nalla Nudi — ನಲ್ಲ ನುಡಿ

> *"Using your mother tongue as a ladder to learn the world."*

Nalla Nudi is an offline-first Android dictionary app built for Kannada-medium 
school students transitioning to English-medium higher education. Students often 
know the concept but struggle with technical vocabulary — Nalla Nudi bridges 
that gap by providing clear, contextual Kannada explanations for English 
technical terms across STEM and Commerce subjects.

---

## 🎯 The Problem We Solve

Students from Kannada-medium schools face a silent crisis when they enter 
colleges and competitive exams — they understand concepts in their mother tongue 
but freeze when they encounter the same idea in English. A student who 
understands "ಬೆಳಕಿನ ಸಂಶ್ಲೇಷಣೆ" may not recognise "Photosynthesis" in an exam paper.

Standard dictionaries are too broad. Nalla Nudi is a **subject-specific, 
student-first bridge dictionary** built for exactly this transition phase.

---

## ✨ Features

### 🔍 Smart Term Search
- Search any technical term in English and instantly get its Kannada equivalent
- Clear, simple explanations written for students — not academics
- Real-world examples alongside every definition
- Sub-200ms search powered by Room Database

### 🤖 AI-Powered Translations
- Google Gemini integration for terms not yet in the local database
- Context-aware explanations tailored to the student's subject
- Generates simple analogies to make concepts stick

### 📚 Subject Filters
- Browse terms by subject: **Science | Math | Commerce | Computer Science**
- Curated glossaries aligned with Karnataka state board & PU curriculum

### ⭐ My List
- Save difficult words to a personal vocabulary list
- Revisit saved words anytime, fully offline

### 🃏 Flashcard Revision Mode
- Interactive flashcards for saved words
- Flip between English term and Kannada explanation
- Spaced repetition-style revision to improve retention

### 🗣️ Text-To-Speech Pronunciation Guide
- Hear the correct English pronunciation of any term
- Kannada audio support to reinforce mother-tongue understanding
- Reduces fear of mispronunciation in classrooms and interviews

### 💡 Word of the Day
- A new technical term every day to build vocabulary gradually
- Shareable card format to spread learning

### ⚡ 100% Offline First
- Core dictionary works without any internet connection
- AI features activate when online for extended queries
- Designed for students in rural areas with limited connectivity

---

## 🛠️ Technology Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI Framework | Jetpack Compose |
| Local Database | Room Database (pre-loaded glossary) |
| Networking | Retrofit |
| AI Integration | Google Gemini (Google AI SDK) |
| Audio | Android TextToSpeech API |
| Architecture | MVVM + Repository Pattern |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- Android SDK 24+
- A Google AI Studio API key

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/likhitha286-ub/Nalla-Nudi.git
cd Nalla-Nudi
```

2. **API Key Setup**

   Get your free API key from [Google AI Studio](https://aistudio.google.com/) 
   and add it to your `local.properties` file:
