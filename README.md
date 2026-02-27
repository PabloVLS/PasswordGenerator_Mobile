# 🔐 SafePass  
### Modern Android Password Generator

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Material Design](https://img.shields.io/badge/Material--Design-757575?style=for-the-badge&logo=material-design&logoColor=white)
![Min API](https://img.shields.io/badge/Min%20API-24-blue?style=for-the-badge)

> A modern, secure and intuitive Android application for generating strong passwords with real-time session history.

SafePass was built following modern Android development best practices, focusing on clean UI, seamless navigation, and efficient state management.

---

## ✨ Features

### 🔐 Smart Password Generation
- Adjustable length (0–32 characters)
- Uppercase letters toggle
- Numbers toggle
- Special characters toggle
- Real-time generation feedback

### 📋 Instant Copy
- One-tap clipboard copy
- Immediate visual feedback using `Toast`

### 📜 Session History
- Automatically stores generated passwords
- Clean and responsive `RecyclerView`
- Session-based persistence

---

## 🏗️ Architecture

SafePass follows a modular structure using modern Android components.

- **Fragments** – Separation between Generator and History screens  
- **ViewBinding** – Type-safe UI access  
- **RecyclerView** – Optimized list rendering  
- **CardView** – Modern elevated UI components  
- **Singleton Pattern (Kotlin Object)** – Lightweight in-memory data persistence  

---

## 🧭 Navigation

The app uses:

- `BottomNavigationView` for smooth screen switching  
- `Jetpack Navigation Component` for structured fragment management  

This ensures a native Android navigation experience.

---

## 📸 Screenshots

<p align="center">
  <img width="300" src="https://github.com/user-attachments/assets/b6f3679b-2d78-4582-8c8c-5fb65b9070c9" />
  <img width="300" src="https://github.com/user-attachments/assets/500fe40f-48f7-436a-99eb-c3154535561f" />
</p>

---

## 🎥 Demo

> ⚠ Replace the link below with your video

[Watch the full walkthrough]https://youtu.be/vJZwgg3N4gY

---

## 🚀 Getting Started

### 1️⃣ Clone the repository

```bash
git clone https://github.com/yourusername/safepass.git
