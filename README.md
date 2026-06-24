# 🔐 Auth — Firebase Authentication App

An Android application built to explore and implement **Firebase Authentication**, featuring a complete auth flow with email/password sign-up, sign-in, password reset, and a post-login screen.

---

## ✨ Features

- **Sign Up** — Register a new account with email & password
- **Sign In** — Authenticate with existing credentials via Firebase
- **Forgot Password** — Send a password reset email through Firebase
- **Logged In Screen** — Welcome screen shown after successful authentication
- **Sign Out** — Securely log out and return to the login screen with back-stack cleared

---

## 📱 Screenshots

| Login | Logged In |
|-------|-----------|
| *(Add screenshot here)* | *(Add screenshot here)* |

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java |
| Platform | Android (AppCompat) |
| Auth Backend | Firebase Authentication |
| UI | XML Layouts, EdgeToEdge |
| IDE | Android Studio |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest stable)
- A Firebase project with **Email/Password** authentication enabled

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/ByteBerry/<repo-name>.git
   cd <repo-name>
   ```

2. **Connect Firebase**
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a project and register your Android app
   - Download `google-services.json` and place it in the `/app` directory
   - Enable **Email/Password** under Authentication → Sign-in method

3. **Build & Run**
   - Open the project in Android Studio
   - Sync Gradle, then run on an emulator or physical device

> ⚠️ **Note:** `google-services.json` is excluded from this repo for security. You must provide your own Firebase config.

---

## 📁 Project Structure

```
com.byteberry.auth
├── MainActivity.java       # Login screen
├── SignUp.java             # Registration screen
├── ForgotPass.java         # Password reset screen
└── loggedIn.java           # Post-authentication welcome screen
```

---

## 🔒 Security Notes

- `google-services.json` is listed in `.gitignore` and never committed
- Back stack is cleared on sign-out (`FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK`) to prevent back-navigation into authenticated state

---

## 📄 License

```
MIT License — feel free to fork and build on this.
```

---

<p align="center">Made by <a href="https://github.com/ByteBerry">ByteBerry</a> · Learning by Building 🚀</p>
