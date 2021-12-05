package kz.stepanenkos.photosfromnasa.allDates.di

import kz.stepanenkos.photosfromnasa.allDates.data.DefaultAllDatesRepository
import kz.stepanenkos.photosfromnasa.allDates.data.datasource.AllDatesDataSource
import kz.stepanenkos.photosfromnasa.allDates.domain.AllDatesRepository
import kz.stepanenkos.photosfromnasa.ui.dashboard.DashboardViewModel
import kz.stepanenkos.photosfromnasa.utils.mappers.AllDatesApiDataMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val allDatesModule = module {
    viewModel {
        DashboardViewModel(
            allDatesRepository = get()
        )
    }

    single {
        val retrofit: Retrofit = get()
        retrofit.create(AllDatesDataSource::class.java)
    }

    factory<AllDatesRepository> {
        DefaultAllDatesRepository(
            allDatesDataSource = get(),
            allDatesApiDataMapper = get()
        )
    }

    factory<AllDatesApiDataMapper> {
        AllDatesApiDataMapper()
    }
}