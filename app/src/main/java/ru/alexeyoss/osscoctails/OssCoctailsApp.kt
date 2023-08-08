package ru.alexeyoss.osscoctails

import android.app.Application
import android.content.Context
import ru.alexeyoss.features.coctails_list.di.provider.CoctailsComponentDepsProvider
import ru.alexeyoss.features.coctails_list.di.CoctailsDeps

class OssCoctailsApp : Application(),
    CoctailsComponentDepsProvider {

    val appComponent: AppComponent by lazy {
        AppComponent.Initializer.init()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this@OssCoctailsApp)
//        setDebugLogging()
    }

    override fun getCoctailsDeps(): CoctailsDeps = appComponent

//    private fun setDebugLogging() {
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
//    }
}

internal val Context.appComponent: AppComponent
    get() = when (this) {
        is OssCoctailsApp -> appComponent
        else -> applicationContext.appComponent
    }