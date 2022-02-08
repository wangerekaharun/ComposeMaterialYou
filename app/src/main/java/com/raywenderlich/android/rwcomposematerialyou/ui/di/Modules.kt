package com.raywenderlich.android.rwcomposematerialyou.ui.di

import androidx.room.Room
import com.raywenderlich.android.rwcomposematerialyou.ui.data.AppDataBase
import com.raywenderlich.android.rwcomposematerialyou.ui.data.repository.EventsRepository
import com.raywenderlich.android.rwcomposematerialyou.ui.data.repository.EventsRepositoryImpl
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
  single {
    Room.databaseBuilder(
      androidApplication(),
      AppDataBase::class.java,
      "ComposeMaterialYou.db"
    ).fallbackToDestructiveMigration().build()
  }
}
val repositoryModule = module {
  single<EventsRepository> { EventsRepositoryImpl(get()) }
}

val viewModelModule = module {
  viewModel { EventsViewModel(get()) }
}

val appModules = listOf(
  dataModule,
  repositoryModule,
  viewModelModule
)