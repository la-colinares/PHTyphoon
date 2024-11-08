# PH Typhoon
PH Typhoon is an app that displays the top 10 deadliest and destructive typhoons that hit the Philippines. This project was built using Kotlin and Compose multiplatform

## Demo
https://github.com/user-attachments/assets/176ed816-bd7d-45fd-b8b7-5b94ae688dca

## Features
- Top 10 Deadliest Philippine Typhoons
- Top 10 Destructive Philippine Typhoons
- Offline mode

## Tools & Technologies
* Language: [Kotlin](https://kotlinlang.org/)
* IDE: [Android Studio Ladybug | 2024.2.1 Patch 2](https://developer.android.com/studio?gad_source=1&gclid=Cj0KCQiA57G5BhDUARIsACgCYnybw_tkUEspdKTc1ZHyT31rxubq_wmSMZuf34i6J99xmEFpG-_6KGMaAo84EALw_wcB&gclsrc=aw.ds)
* `/composeApp`
  - UI Libraries: [SplashScreen API](https://developer.android.com/develop/ui/views/launch/splash-screen), [Material3 UI](https://m3.material.io/)
  - Local Database: [Room (Kotlin Multiplatform)](https://developer.android.com/kotlin/multiplatform/room)
  - JSON Serializer: [KotlinX Serialization](https://github.com/Kotlin/kotlinx.serialization)
  - Dependency Injection: [Koin (Kotlin Multiplatform)](https://insert-koin.io/docs/reference/koin-mp/kmp)
  - Networking: [Ktor Client](https://ktor.io/docs/client-create-multiplatform-application.html#android-activity)
  - Image Loader: [Coil Compose](https://coil-kt.github.io/coil/compose/)
  - Webview/Browser: [Chrome Custom Tabs](https://developer.chrome.com/docs/android/custom-tabs)
  - Navigation: [Compose Navigation](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html)
* `/server`
  - Server: [Ktor Server](https://ktor.io/docs/server-create-a-new-project.html#create-project-with-the-ktor-project-generator)
  - API Auth Provider : [Ktor API Key](https://github.com/LukasForst/ktor-plugins/)
  - Dependency Injection: [Koin Ktor](https://insert-koin.io/docs/reference/koin-ktor/ktor)
  - Web Service Deployment: [Render](https://render.com/), [Docker](https://www.docker.com/)