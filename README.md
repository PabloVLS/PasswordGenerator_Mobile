# 🔐 SafePass | Password Generator & History

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Material Design](https://img.shields.io/badge/Material--Design-757575?style=for-the-badge&logo=material-design&logoColor=white)

An elegant and robust Android application designed to generate ultra-secure passwords with real-time history tracking. This project implements modern Android UI patterns and seamless navigation.

---

## 🚀 Key Features

* **Customizable Strength:** Adjust password length from 0 to 32 using a smooth `SeekBar`.
* **Granular Filters:** Dedicated `Switches` for Uppercase, Numbers, and Special Symbols.
* **Modern UX:** WhatsApp-inspired `BottomNavigationView` for fluid screen transitions.
* **Quick Copy:** One-tap clipboard integration with instant `Toast` feedback.
* **Session History:** Automatic persistence of generated passwords in a clean `RecyclerView` list.

---

## 🛠️ Technical Challenges Solved

### 📱 Challenge 1: Navigation UX
Implemented the **Jetpack Navigation Component** to handle fragment switching. The `BottomNavigationView` is synchronized with the `NavGraph` to ensure a native, responsive feel.

### 💾 Challenge 2: Persistence & Logic
Developed a **Singleton-based storage** system using Kotlin `Objects`. This allows data to flow seamlessly between the Generator and History fragments without the overhead of a database.

---

## 📐 Architecture & Tools

| Tool | Purpose |
| :--- | :--- |
| **ViewBinding** | Safe interaction with UI components |
| **Fragments** | Modularity between Generator and History |
| **CardView** | Elevated UI for password highlighting |
| **RecyclerView** | Memory-efficient list rendering |

---

## 📺 Demonstration

> [!IMPORTANT]
> **Watch the full walkthrough here:** [Link to Unlisted YouTube Video](PASTE_YOUR_LINK_HERE)

---

## 🏁 Setup

1.  **Clone:** `git clone https://github.com/youruser/repo.git`
2.  **Open:** Import into Android Studio (Ladybug or newer).
3.  **Run:** Target API 24 or higher.

---
<p align="center">
  Made with ❤️ for Android Mobile Development Activity
</p>
