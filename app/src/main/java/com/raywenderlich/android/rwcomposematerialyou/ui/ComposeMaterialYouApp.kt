package com.raywenderlich.android.rwcomposematerialyou.ui

import android.app.Application
import com.raywenderlich.android.rwcomposematerialyou.ui.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ComposeMaterialYouApp: Application() {

  override fun onCreate() {
    super.onCreate()

    initKoin()
  }

  private fun initKoin() {
    startKoin {
      androidLogger(Level.NONE)
      androidContext(this@ComposeMaterialYouApp)
      modules(appModules)
    }
  }
}