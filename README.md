# Temp Contacts

**Temp Contacts** is a simple and lightweight contact management app built with Kotlin. It allows users to create, save, and delete temporary contacts stored locally on their device. The app is designed using the MVVM architecture pattern to ensure clean code separation and scalability.

## Features

- **Add Contacts**: Create temporary contacts with essential details like name, phone number, and email.
- **Local Storage**: All contacts are stored locally using **Room Database** for offline access.
- **Delete Contacts**: Easily delete contacts that are no longer needed.
- **MVVM Architecture**: Implements the MVVM (Model-View-ViewModel) architecture pattern, promoting clean, maintainable, and scalable code.
- **Asynchronous Operations**: Uses Kotlin Coroutines to handle database operations smoothly without blocking the main UI thread.

## Tech Stack

- **Kotlin**: Programming language used for development.
- **Room Database**: Manages data storage locally on the device.
- **MVVM Architecture**: Ensures separation of concerns between the UI and data handling layers.
- **Coroutines**: For asynchronous, non-blocking operations.
