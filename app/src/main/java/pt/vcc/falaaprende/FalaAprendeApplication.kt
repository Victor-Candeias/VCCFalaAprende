package pt.vcc.falaaprende

import android.app.Application
import pt.vcc.falaaprende.di.AppContainer
import pt.vcc.falaaprende.di.AppDependencies

class FalaAprendeApplication : Application() {
    val dependencies: AppDependencies by lazy { AppContainer() }
}
