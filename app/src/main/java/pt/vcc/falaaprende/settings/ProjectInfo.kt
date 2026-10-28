package pt.vcc.falaaprende.settings

import pt.vcc.falaaprende.BuildConfig

/** Informação pública da compilação, sem identificadores pessoais. */
data class ProjectInfo(
    val appName: String,
    val versionName: String,
    val versionCode: Int,
    val buildType: String,
    val minSdk: Int,
    val targetSdk: Int
)

object ProjectInfoProvider {
    fun current(): ProjectInfo = ProjectInfo(
        appName = "VCC Fala & Aprende",
        versionName = BuildConfig.VERSION_NAME,
        versionCode = BuildConfig.VERSION_CODE,
        buildType = BuildConfig.BUILD_TYPE,
        minSdk = 26,
        targetSdk = 35
    )
}
