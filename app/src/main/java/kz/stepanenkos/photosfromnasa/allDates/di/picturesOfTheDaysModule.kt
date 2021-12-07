package kz.stepanenkos.photosfromnasa.allDates.di

import kz.stepanenkos.photosfromnasa.allDates.data.DefaultNasaRepository
import kz.stepanenkos.photosfromnasa.allDates.data.datasource.NasaDataSource
import kz.stepanenkos.photosfromnasa.allDates.domain.NasaRepository
import kz.stepanenkos.photosfromnasa.allDates.presentation.PicturesOfTheDaysViewModel
import kz.stepanenkos.photosfromnasa.utils.mappers.PicturesOfTheDaysApiDataMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val picturesOfTheDaysModule = module {
    viewModel {
        PicturesOfTheDaysViewModel(
            nasaRepository = get()
        )
    }

    single {
        val retrofit: Retrofit = get()
        retrofit.create(NasaDataSource::class.java)
    }

    factory<NasaRepository> {
        DefaultNasaRepository(
            nasaDataSource = get(),
            picturesOfTheDaysApiDataMapper = get()
        )
    }

    factory<PicturesOfTheDaysApiDataMapper> {
        PicturesOfTheDaysApiDataMapper()
    }
}