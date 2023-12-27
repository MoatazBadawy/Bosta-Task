<h1 align="center">Bosta: Tech Company Task</h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.9.xxx-a97bff"/></a>
  <img alt="Clean Architecture" src="https://img.shields.io/badge/Clean-Architecture-white"/>
  <img alt="MVVM" src="https://img.shields.io/badge/MVVM-Architecture-orange"/>
</p>

<p align="center">  
📦 Bosta task. Built with Kotlin, Jetpack Compose. Powered by Retrofit, OkHttp, Coroutines, Android Jetpack, and Hilt. Structured by Clean Architecture, MVVM, Repository Pattern.
</p>
</br>

https://github.com/MoatazBadawy/Bosta-Task/assets/63272288/d104ffd7-cf81-4c9a-b192-1e2dbb2e65a0

#### 🌟 Project Overview
The app contains the following features
- [x] Get a random user every time open the app, and display Info and his albums in a list.
- [x] Use Navigation Compose to navigate between app screens, and send arguments using parcelable. 
- [x] Search for images by title, and use a delay to give space to the user to write what he wants and reduce the number of requests on the API. 
- [x] Display the image on a new screen, and ZoomIn-ZoomOut, and share the image with friends outside the application.

#### 🏗️ Project Architecture
The app follows the Clean Architecture structure and MVVM to provide logical simplicity and maintainability. <br> 
- The domain layer contains UseCases that encapsulate a single, specific task that is part of the application's business logic. <br>
- The data layer implements the repository interface defined in the domain layer, providing a single source of truth for data. <br>
- The UI layer cnotance view and ViewModel layers, it uses all the components and classes related to the Android framework to get the data from the ViewModel layer and display it on the device.

<img src="https://koenig-media.raywenderlich.com/uploads/2019/06/Clean-Architecture-graph.png" width="500" />

#### 🧩 Structure
The app is structured by feature, every feature has it is one (data - domain - UI). 
> [!NOTE]
> This structure is inside the project app (we didn't use Modulaztraion).

      + app/ 
          + di <- handle app dependency injections modules.
          + main <- contains mainactivity class.
      + common/ 
          + ui <- the common ui components between the features.
      + feature's/
          + photos/ 
             + data <- implements the repository interface defined in the domain layer
               - remote 
               - repositories
             + domain <- contains UseCases that encapsulate the business logic.
               - entities 
               - repository
               - usecases
             + UI <- uses MVVM with ViewModels exposing StateFlow that the UI consumes.
               - view
               - viewmodel
         + profile <- have the same files as the photos feature.
              

## 🔧 Tech stack & Open-source libraries
- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) is Android's recommended by Google modern toolkit for building native UI.
- Jetpack
  - Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel: Manages UI-related data holder and lifecycle awareness. Allows data to survive configuration changes such as screen rotations.
  - StateFlow: For reactive style programming (from VM to UI). 
  - [Hilt](https://dagger.dev/hilt/): for dependency injection.
  - [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) - Used to navigate between compose screens
  - [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.
- Architecture
  - Clean Architecture (Data - Domain - UI)
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Coil](https://coil-kt.github.io/coil/): An image loading library for Android backed by Kotlin Coroutines.
- [Kotlin-DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Used to handle gradle dependencies and config versions
- [ksp](https://github.com/google/ksp): Kotlin Symbol Processing API.
