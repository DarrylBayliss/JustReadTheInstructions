# Just Read The Instructions

An app showing rocket launches using the [SpaceX REST Api](https://github.com/r-spacex/SpaceX-API). 

Written for Android 12 using Jetpack Compose.

# Commentry

The app uses clean architecture, with the packages organised like so:

- data
- di
- domain
- presentation
- usecase

The two screens in the app are **MainActivity.kt** and **LaunchDetailActivity.kt**. MainActivity.kt has a corresponding **ViewModel**, responsible for populating the screens with data.

**MainActivity.kt** shows a listview of rockets, queried from the network.

Tapping a rocket in the list will transition the app to the **LaunchDetailActivity.kt** screen.

**LaunchDetailActivity.kt** shows particular information about a rocket. The data is passed in from **MainActivity.kt** via a launch object intent.

# Dependencies

The following dependencies were added to the app:

Coil (Jetpack compose image loading)
Retrofit / okhttp (Networking)
Moshi (Json serialisation / deserialisation)
Hilt (Dependency Injection)
Android X Splash Screen API

# Icon Logo

The App Icon is made by [Freepik](https://www.freepik.com) from [flaticon](https://www.freepik.com).
