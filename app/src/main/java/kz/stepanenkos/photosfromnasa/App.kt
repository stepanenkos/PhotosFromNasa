package kz.stepanenkos.photosfromnasa

import android.app.Application
import kz.stepanenkos.photosfromnasa.allDates.di.picturesOfTheDaysModule
import kz.stepanenkos.photosfromnasa.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(
                applicationModule,
                picturesOfTheDaysModule,
            )
        }
    }
}