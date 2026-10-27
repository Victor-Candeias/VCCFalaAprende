plugins { id("com.android.library"); id("org.jetbrains.kotlin.android") }
android {
    namespace = "pt.vcc.falaaprende.core.data"
    compileSdk = 35
    defaultConfig { minSdk = 26 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}
dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:common"))
    testImplementation("junit:junit:4.13.2")
}
