<img width="1920" height="1080" alt="Screenshot 2026-06-24 135245" src="https://github.com/user-attachments/assets/0ab0a883-e3cf-482c-8f28-800defa75e23" />🔐 Auth — Firebase Authentication App

An Android application built to explore and implement **Firebase Authentication**, featuring a complete auth flow with email/password sign-up, sign-in, password reset, and a post-login screen.

---

✨ Features

Sign Up— Register a new account with email & password
Sign In— Authenticate with existing credentials via Firebase
Forgot Password— Send a password reset email through Firebase
Logged In Screen— Welcome screen shown after successful authentication
Sign Out— Securely log out and return to the login screen with back-stack cleared

---

📱Logged In
 
<img width="1920" height="1080" alt="Screenshot 2026-06-24 134649" src="https://github.com/user-attachments/assets/ca0f4d5b-a4a5-40f5-82d0-8f278f924025" />

---

🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java |
| Platform | Android (AppCompat) |
| Auth Backend | Firebase Authentication |
| UI | XML Layouts |
| IDE | Android Studio |

---


📁 Project Structure

```
com.byteberry.auth
├── MainActivity.java       # Login screen
├── SignUp.java             # Registration screen
├── ForgotPass.java         # Password reset screen
└── loggedIn.java           # Post-authentication welcome screen
```

---

🔒 Security Notes

- `google-services.json` is listed in `.gitignore` and never committed
- Back stack is cleared on sign-out (`FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK`) to prevent back-navigation into authenticated state

---


---

<p align="center">Made by <a href="https://github.com/root-ari">root-ari</a> · Learning Firebase🔥</p>
